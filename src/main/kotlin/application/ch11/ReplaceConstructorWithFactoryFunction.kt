package application.ch11

// 11.8 생성자를 팩터리 함수로 바꾸기
// 이펙티브 자바에서도 이야기하는 생성자를 팩터리 함수로 바꾸는 것에 대한 내용이다.
// 코틀린에서는 비공개 생성자로 만든 후 컴패니언 오브젝트를 사용해서 구현이 가능하다.

class Employee(
        val name: String,
        val type: String,
)

class UpgradeEmployee private constructor(
        val name: String,
        val type: String,
) {
    companion object {
        fun of(name: String, type: String): UpgradeEmployee {
            return UpgradeEmployee(name, type)
        }
    }
}

fun main() {
    val employee = Employee("harry", "M")
    val upgradeEmployee = UpgradeEmployee.of("harry", "M")
}