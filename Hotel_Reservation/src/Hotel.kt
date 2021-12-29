import java.util.*

class Hotel(numberOfRooms: Int) {
    //
    private val numroom: Int
    private val rooms = mutableListOf<Room>()
    private val customers = mutableListOf<Customer>()
    init {
        numroom = numberOfRooms
        createRooms()
    }
    private fun createRooms() {

        for (i in 0 until numroom) {
            val type = (1..2).random()
            rooms.add(Room(type, i))
        }
    }
    fun listRooms() {
        println("Room Type  Room Number  Booked by")
        for (i in 0 until numroom) {
            val currentRoom = rooms[i]
            println("    ${currentRoom.type}          ${currentRoom.number}          ${currentRoom.status}")
        }
    }
    fun bookRoom(customerID: String, roomID: Int) {

        val check = rooms.find { it.number == roomID } ?: return
        if (check.customerID == null) {
            check.customerID=customerID
            check.status = "Yes"
            println("The Room has been reserved for you. Thank you!")
        } else {

            println("The Room is  reserved . Sorry try reserving another room")
        }
    }

    fun checkout(customerID: String) {
        val check = rooms.find { it.customerID == customerID } ?: return
        check.status = "No"
        println("We hope that you have enjoyed your time here.Please come back again")
    }

    fun createNewCustomer(customerID: String, name: String, age: Byte): String {
        val newCustomer = Customer(customerID, name, age)
        customers.add(newCustomer)
        println("The new user has been added with $customerID")
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }

    fun generateCustomerId(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }
}
