package domain.ch7

class Order(
        val quantity: Double,
        val item: Item
) {
    fun getPrice(): Double {
        return getBasePrice() * getDiscountFactor()
    }

    fun getBasePrice(): Double {
        return this.item.price * this.quantity
    }

    fun getDiscountFactor(): Double {
        var discountFactor = 0.98
        if (getBasePrice() > 1000) discountFactor -= 0.03
        return discountFactor
    }
}