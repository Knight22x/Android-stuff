abstract class Shape() {

    abstract val side: Int

    //abstract val name : String
    private val shapes = hashMapOf(
        3 to "Triangle", 4 to "Square", 6 to "Hexagon", 0 to "Circle 0 straight lines",
        1 to "Circle 1 curved line", -1 to "Circle ∞ Infinite points"
    )

    fun displayType() {

        var result = shapes[side]
        if (result.isNullOrBlank())  //handling
        {
            println("Undefined Shape")
            return
        }

        println(result)

    }
}


    class Shapeholder(val sides: Int?) : Shape() {

        override val side: Int = sides ?: 99
        //override var name: String = " Circle"


    }


//class Rectangle(): Shape() {
//    override val side: Int = 4
//    override var name: String = " Rectangle"
//
//    override fun displayType() {
//        println(name)
//    }
//}
//class Triangle(): Shape() {
//    override val side: Int = 3
//    override var name: String = " Triangle"
//    override fun displayType() {
//        println(name)
//    }
//}

