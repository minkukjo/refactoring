package domain.ch6

import application.ch6.baseRate
import kotlinx.serialization.Serializable

@Serializable
class Reading(
        val customer: String,
        val quantity: Int,
        val month: Int,
        val year: Int
) {
    fun calculateBaseCharge(): Int {
        return baseRate(this.month, this.year) * this.quantity
    }
}