const val red = "\u001b[31m"
const val reset = "\u001b[0m"
const val yellow = "\u001b[33m"
const val cyan = "\u001b[36m"
fun printlnWithColor(message: String?, color: String) {
    println(color + message + reset)
}
fun printlnFailure(message: String?) = printlnWithColor(message, red)

fun printlnSuccess(message: String?) = printlnWithColor(message, cyan)

fun printlnWarning(message: String?) = printlnWithColor(message, yellow)
