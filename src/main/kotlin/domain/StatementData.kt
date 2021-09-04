package domain

class StatementData(val customer: String, val performances: List<Performance>, var totalAmount: Int = 0, var totalVolumeCredits: Int = 0)