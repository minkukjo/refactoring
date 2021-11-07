package domain.ch7

class PrimitiveOrder(
        var priority: Priority
) {
    fun getPriorityString(): String {
        return this.priority.value
    }

    fun setPriority(aString: String) {
        this.priority = Priority(aString)
    }
}