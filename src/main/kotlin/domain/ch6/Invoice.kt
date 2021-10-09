package domain.ch6

import java.time.LocalDate

class Invoice(
        val orders: List<Order>,
        var dueDate: LocalDate = LocalDate.now(),
        val customer: String
)