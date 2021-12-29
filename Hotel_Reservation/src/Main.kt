var running = true
var input: String = ""
fun main() {
    val hotel1 = Hotel(6)
    // hotel1.listRooms()
    // hotel1.bookRoom(3, 2)
    // hotel1.listRooms()
    // hotel1.checkout(3)
    // hotel1.checkout(2)
    // hotel1.listRooms()
    while (running) {
        println("Please select an option to proceed")
        println("1 for Current Reservations & Room Availability ")
        println("2 for Room Bookings ")
        println("3 for New Customer ")
        println("4 for Customer Checkout")
        println("5 to exit")
        when (readLine()) {
            "1" -> hotelInformation(hotel1)
            "2" -> customerBooking(hotel1)
            "3" -> newCustomerCreation(hotel1)
            "4" -> customerCheckout(hotel1)
            "5" -> terminateProgram()
        }
//        try {
//            promptMessage()
//        } catch (e: Exception) {
//            printlnFailure(e.message)
//            printlnWarning("Please Try again")
//        }
    }
}
fun customerBooking(hotel: Hotel) {
    println("Please Enter The Customer's id")
    val id = readLine()
    println("Please Enter The Room Number in which to be booked for this customer")
    val rid = readLine()
    id?.let {
        rid?.let { it1 -> hotel.bookRoom(it, it1.toInt()) }
    }
}
fun customerCheckout(hotel: Hotel) {
    println("Please Enter The Customer's id")
    val id = readLine()
    id?.let { hotel.checkout(id) }
}
fun newCustomerCreation(hotel: Hotel) {
    val id = hotel.generateCustomerId()
    println("Please Enter The Customer's Name")
    val name = readLine()
    println("Please Enter The Customer's age")
    val age = readLine()
    age?.let {
        name?.let { name -> hotel.createNewCustomer(id, name, age.toByte()) }
        //
    }
}
fun hotelInformation(hotel: Hotel) {
    hotel.listRooms()
}
fun terminateProgram() {
    println("Thank you for using our booking service!")
    running = false
}
