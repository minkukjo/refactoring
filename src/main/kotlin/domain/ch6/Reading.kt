package domain.ch6

import kotlinx.serialization.Serializable

@Serializable
class Reading(
        val customer: String,
        val quantity: Int,
        val month: Int,
        val year: Int,
        var baseCharge: Int = 0,
        var taxableCharge: Int = 0,
)