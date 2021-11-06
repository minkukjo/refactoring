package domain.ch7

class Order(
        var priority: Priority
) {
    fun getPriorityString(): String {
        return this.priority.value
    }

    fun setPriority(aString: String) {
        this.priority = Priority(aString)
    }
}