data class Room(
    var type: Type,
    var number: Int,
    var status: Boolean = false,
    var customerID: String? = null
// Enum -sealed class
)
enum class Type {
    Double, Single
}
