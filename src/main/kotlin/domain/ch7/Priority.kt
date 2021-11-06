package domain.ch7

class Priority(
        val value: String
) {
    companion object {
        fun regalValues(): List<String> {
            return listOf("low", "normal", "high", "rush")
        }
    }

    fun equal(other: Priority): Boolean {
        return this.index() == other.index()
    }

    private fun index(): Int {
        return Priority.regalValues().indexOf(this.value)
    }

    fun higherThan(other: Priority): Boolean {
        return this.index() < other.index()
    }

    fun lowerThan(other: Priority): Boolean {
        return this.index() > other.index()
    }
}