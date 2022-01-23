import java.util.*

class Hotel(numberOfRooms: Int) {
    //
    // val x = Array<Room>(numberOfRooms)
    private val numberOfRooms: Int
    private val rooms = mutableListOf<Room>()
    private val customers = mutableListOf<Customer>()

    init {
        // for each
        this.numberOfRooms = numberOfRooms
        createRooms()
    }

    private fun createRooms() {
        val types = mutableListOf(Type.Single, Type.Double)
        for (i in 0 until numberOfRooms) {
            val randomIndex = (0..1).random()
            rooms.add(Room(types[randomIndex], i))
        }
    }

    fun listRooms() {
        println("Room Type  Room Number  Is Booked?")
        for (i in 0 until numberOfRooms) {
            val currentRoom = rooms[i]
            println("    ${currentRoom.type}          ${currentRoom.number}          ${currentRoom.status}")
        }
    }

    fun bookRoom(customerID: String, roomID: Int) {
        if (isHotelCurrentlyFull()) {
            println("Sorry the hotel is currently full. Please check again later")
            return
        }
      
        rooms.firstOrNull { it.number == roomID }?.let { // Scoped function
            if (it.customerID == null) {
                it.customerID = customerID
                it.status = true
                println("The Room has been reserved for you. Thank you!")
            } else {
                println("The Room is  reserved . Sorry try reserving another room")
            }
        }
    }
    
    fun isHotelCurrentlyFull(): Boolean {
        var bookedCurrentRoom = 0
        rooms.forEach {
            if (it.status) {
                bookedCurrentRoom++
            }
        } 
        return rooms.size == bookedCurrentRoom 
    }

    fun checkout(customerID: String) {
        rooms.firstOrNull { it.customerID == customerID }?.let {
            it.status = false
            println("We hope that you have enjoyed your time here.Please come back again")
        }
    }

    fun createNewCustomer(customerID: String, name: String, age: Int) {
        val newCustomer = Customer(customerID, name, age)
        customers.add(newCustomer)
        println("The new user has been added with $customerID")
    }

    fun generateCustomerId(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }
}
