package domain.ch8

import java.time.LocalDateTime

class Customer(
        val name: String,
        private val discountRate: Double,
        val contract: CustomerContract = CustomerContract(LocalDateTime.now(), discountRate)
) {
    fun updateDiscountRate(discountRate: Double) {
        this.contract.discountRate += discountRate
    }

    fun becomePreferred() {
        this.updateDiscountRate(0.3)
        // TODO Someting cool
    }

    fun applyDiscount(amount: Long): Double {
        return amount * contract.discountRate
    }
}