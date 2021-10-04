package domain.ch1

import kotlinx.serialization.Serializable

@Serializable
class Invoice(val customer: String, val performances: List<Performance>)