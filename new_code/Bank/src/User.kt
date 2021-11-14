data class User(
    var name: String,
    var age: Int,
    var id: String,
    var creationDate: String,
    var updatedAt: String = creationDate,
    var balance: Int = 0
)
