package domain.ch7

class Order(
        val quantity: Double,
        val item: Item
) {
    fun getPrice(): Double {
        val basePrice = this.item.price * this.quantity
        var discountFactor = 0.98
        if (basePrice > 1000) discountFactor -= 0.03
        return basePrice * discountFactor
    }
}