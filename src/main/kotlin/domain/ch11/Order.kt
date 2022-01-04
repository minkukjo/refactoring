package domain.ch11

class Order(
        val quantity: Long,
        val itemPrice: Long,
) {
    fun finalPrice(): Double {
        val basePrice = this.quantity * this.itemPrice
        return this.discountedPrice(basePrice)
    }

    private fun discountedPrice(basePrice: Long): Double {
        return when (discountLevel()) {
            1L -> basePrice * 0.95
            2L -> basePrice * 0.9
            else -> 0.0
        }
    }

    private fun discountLevel(): Long {
        return if (this.quantity > 100) {
            2L
        } else {
            1L
        }
    }
}