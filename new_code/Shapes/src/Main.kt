fun main(args: Array<String>) {
    println("Enter the number of sides")
    val input = readLine()
    val t = Shapeholder(input?.toIntOrNull())   //check
    t.displayType()
}