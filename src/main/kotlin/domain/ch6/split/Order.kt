package domain.ch6.split

import kotlinx.serialization.Serializable

@Serializable
class Order(
        val item: String,
        val status: String
)