import java.lang.IllegalArgumentException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

open class Bank {
    var total_money: Int = 0
    val users = mutableListOf<User>()
    fun createUser(name: String, age: Int): String {
        val creationDate = getCurrentTime()
        val newuser = User(name, age, generateUserId(), creationDate)
        users.add(newuser)
        printlnSuccess("The new user has been added with ${newuser.id}")
        return newuser.id
    }

    fun validateCreateUser(name: String?, age: Int?): String {
        if (name == null || age == null)
            throw CannotCreateUser()

        return createUser(name, age)
    }

    fun validateWithdrawal(id: String?, value: Int?) = validateUserExistence(id) {

        if (value == null || value < 0 || it.balance < value)
            InvalidWithdrawalValue()
        else
            withdraw(it, value)
    }

    fun validateDeposit(id: String?, value: Int?) = validateUserExistence(id) {

        if (value == null || value < 0)
            InvalidDepositValue()
        else
            deposit(it, value)
    }
    fun deposit(user: User, value: Int) {

        user.balance += value
        total_money += value
        printlnSuccess("User has deposited $value $ and the new balance is ${user.balance} $")
    }

    fun withdraw(user: User, value: Int) {

        user.balance -= value
        total_money -= value
        printlnSuccess("User has withdrawn $value $ and the new balance is ${user.balance} $ ")
    }

    fun updateUserName(id: String?, name: String?) = validateUserExistence(id) {
        if (name == null) {
            throw IllegalArgumentException("Name is invalid")
        }
        val oldValue = it.name
        it.name = name
        lastUpdated(it)
        printlnSuccess("User has been updated from $oldValue to $name .")
    }

    fun updateUserAge(id: String?, age: Int?) = validateUserExistence(id) { user ->
        if (age == null) {
            throw IllegalArgumentException("Invalid Age")
        }
        val oldValue = user.age
        user.age = age
        lastUpdated(user)
        printlnSuccess("User has been updated from $oldValue Years to $age Years")
    }

    fun printBankInfo() {
        printlnWarning("Total Money in the bank is $total_money $$")
        printlnWarning("Total Number of the users are ${users.size}")
        println("---------------------------------------")
        for (i in users) {
            println(i.toString())
            println("##########################")
        }
    }

    fun transferMoney(From_id: String?, To_id: String?, value: Int?) {
        validateUserExistence(From_id) { from_user ->
            validateUserExistence(To_id) { to_user ->
                validateWithdrawal(from_user.id, value)
                validateDeposit(to_user.id, value)
                printlnSuccess("Transfer has been successful ")
            }
        }
    }
    fun removeUser(id: String?) = validateUserExistence(id) {
        total_money -= it.balance
        users.remove(it)
        printlnSuccess("User with id ${it.id} has been removed")
    }
    private fun lastUpdated(user: User) {
        user.updatedAt = getCurrentTime()
    }
    private fun getCurrentTime(): String {

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")
        return current.format(formatter)
    }

    private fun generateUserId(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }

    private inline fun findUser(id: String?, callback: (User) -> Unit) {

        val user = users.firstOrNull { it.id == id } ?: throw UserNotFound()
        callback(user)
    }

    private fun validateUserExistence(id: String?, callback: (User) -> Unit) {
        findUser(id, callback)
    }
}
