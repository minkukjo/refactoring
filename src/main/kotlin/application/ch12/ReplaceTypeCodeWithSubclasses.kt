package application.ch12

// 12.6 타입 코드를 서브클래스로 바꾸기
// 타입(Enum)으로 관리되는 값을 빼고 클래스로 변경

class Employee3(
        val name: String,
        val type: String,
)

fun createEmployee(name: String, type: String): Employee3 {
    return Employee3(name, type)
}

open class FixedEmployee(val name: String)

class Engineer(name: String) : FixedEmployee(name) {
    fun getType(): String {
        return "engineer"
    }
}

class SalesPerson(name: String) : FixedEmployee(name) {
    fun getType(): String {
        return "salesperson"
    }
}

fun createdEmployee(name: String): FixedEmployee {
    return when (name) {
        "engineer" -> Engineer(name)
        "salesperson" -> SalesPerson(name)
        else -> FixedEmployee(name)
    }
}