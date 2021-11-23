package domain.ch8

import java.time.LocalDateTime

class CustomerContract(
        val startDate: LocalDateTime,
        var discountRate: Double,
)
