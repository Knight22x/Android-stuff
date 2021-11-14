class CannotCreateUser() : Exception("The user can not be created due to invalid input")

class UserNotFound() : Exception("The user can not be found")

class InvalidWithdrawalValue() : Exception(
    "Withdrawal's value is invalid"
)
class InvalidDepositValue() : Exception("Deposit's value is invalid")
