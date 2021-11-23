package domain.ch8

class Customer(
        val name: String,
        var discountRate: Double,
        val contract: CustomerContract
) {
    fun becomePreferred() {
        this.discountRate += 0.3
        // TODO Someting cool
    }

    fun applyDiscount(amount: Long): Double {
        return amount * discountRate
    }
}