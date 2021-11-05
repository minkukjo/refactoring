package application.ch7

fun main() {
    val orders = listOf("high", "rush", "low", "normal")
    val highPriorityCount = orders.filter { order -> order == "high" || order == "rush" }.size
}