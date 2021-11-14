import java.util.*

fun main() {
    val Banking = Bank()
    val User01 = Banking.validateCreateUser("Abdelrahman", 80)
    val User02 = Banking.validateCreateUser("Hesham", 100)
    Banking.validateDeposit(User01, 200)
    Banking.validateWithdrawal(User01, 50)
    Banking.updateUserName(User01, "Lol")
    Banking.updateUserAge(User01, 307)
    Banking.transferMoney(User01, User02, 50)
    var running = true
    fun promptMessage() {
        println("Please select an option to proceed")
        println("1 for Adding a new user")
        println("2 for deleting a user")
        println("3 for printing the bank's info")
        println("4 for Making a deposit")
        println("5 for Making a withdrawal ")
        println("6 for updating a user's name ")
        println("7 for updating a user's age ")
        println("8 for transferring money from a user to a another user ")
        println("9 to exit")

        val input = readLine()
        if (input == "1") {
            println(" Please enter the User's name")
            val name = readLine()
            println("Please enter the User's Age")
            val age = readLine()?.toIntOrNull()
            val User03 = Banking.validateCreateUser(name, age)
        } else if (input == "2") {
            println(" Please enter the User's id to proceed with the delete action")
            val delete = readLine()
            Banking.removeUser(delete)
        } else if (input == "3") {
            Banking.printBankInfo()
        } else if (input == "4") {
            println(" Please enter the User's id to proceed with the deposit action")
            val input = readLine()
            println(" Please enter the desired amount to continue the transaction")
            val value = readLine()?.toIntOrNull()
            Banking.validateDeposit(input, value)
        } else if (input == "5") {
            println(" Please enter the User's id to proceed with the Withdrawal action")
            val input = readLine()
            println(" Please enter the desired amount to continue the transaction")
            val value = readLine()?.toIntOrNull()
            Banking.validateWithdrawal(input, value)
        } else if (input == "6") {
            println(" Please enter the User's id to proceed with the update action")
            val input = readLine()
            println(" Please enter the new desired user's name")
            val input2 = readLine()
            Banking.updateUserName(input, input2)
        } else if (input == "7") {
            println(" Please enter the User's id to proceed with the update action")
            val input = readLine()
            println(" Please enter the new desired user's age")
            val input2 = readLine()?.toIntOrNull()
            Banking.updateUserAge(input, input2)
        } else if (input == "8") {

            println(" Please enter the User's id in which the money would be transferred from such")
            val input = readLine()
            println("Please enter the User's id in which the money would be transferred to such")
            val input2 = readLine()
            println("Please enter the desired amount in order to complete the transaction ")
            val input3 = readLine()?.toIntOrNull()
            Banking.transferMoney(input, input2, input3)
        } else if (input == "9") {
            println("Thank you for using our banking service!")
            running = false
        } else {
            println("You have entered an invalid selection , Please enter a valid option between 1 and 9")
        }
    }

    while (running) {

        try {
            promptMessage()
        } catch (e: Exception) {
            printlnFailure(e.message)
            printlnWarning("Please Try again")
        }
    }
}
