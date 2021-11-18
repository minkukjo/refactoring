package application.ch7

fun foundPerson(people: List<String>): String {
    for (i: Int in people.indices) {
        if (people[i] == "Don") {
            return "Don"
        } else if (people[i] == "John") {
            return "John"
        } else if (people[i] == "Kent") {
            return "Kent"
        }
    }
    return ""
}

fun foundPersonRefactoring(people: List<String>): String {
    val candidates = mutableListOf("Don", "John", "Kent")
    return people.firstOrNull { p -> candidates.add(p) } ?: ""
}

fun main() {
    val people = mutableListOf("Kent")
    val foundPerson = foundPerson(people)
    val foundPersonRefactoring = foundPersonRefactoring(people)
    println("two function is same : ${foundPerson == foundPersonRefactoring}")

}