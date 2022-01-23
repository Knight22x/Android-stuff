// class Main {
var running = true
fun main() {
    val hotel1 = Hotel(4)

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
    }
}

fun customerBooking(hotel: Hotel) {
    if (hotel.isHotelCurrentlyFull()) {
        println("Sorry the hotel is currently full. Please check again later")
        return
    }
    println("Please Enter The Customer's id")
    val id = readLine()
    println("Please Enter The Room Number in which to be booked for this customer")
    val rid = readLine()
    id?.let {
        rid?.let { id -> hotel.bookRoom(it, id.toInt()) }
    }
}

fun customerCheckout(hotel: Hotel) {
    println("Please Enter The Customer's id")
    val id = readLine()
    id?.let { hotel.checkout(id) }
}

fun newCustomerCreation(hotel: Hotel) {
    if (hotel.isHotelCurrentlyFull()) {
        println("Sorry the hotel is currently full. Please check again later")
        return
    }
    val id = hotel.generateCustomerId()
    println("Please Enter The Customer's Name")
    val name = readLine()
    println("Please Enter The Customer's age")
    val age = readLine()
    age?.let {
        name?.let { name -> hotel.createNewCustomer(id, name, age.toInt()) }
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
// }
