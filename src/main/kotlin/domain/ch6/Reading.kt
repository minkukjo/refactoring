package domain.ch6

import application.ch6.baseRate
import application.ch6.taxThreshold
import kotlinx.serialization.Serializable

@Serializable
class Reading(
        val customer: String,
        val quantity: Int,
        val month: Int,
        val year: Int
) {
    fun baseCharge(): Int {
        return baseRate(this.month, this.year) * this.quantity
    }

    fun taxableCharge(): Int {
        return 0.coerceAtLeast(this.baseCharge() - taxThreshold(this.year))
    }
}