package application.ch12

// 12.1 메서드 올리기
// 같은 슈퍼 클래스를 상속받는 두 서브 클래스에서 같은 로직이 있다면 메서드를 부모쪽으로 올려서 중복을 제거하는 기법

open class Party

class Employee(
        private val monthlyCost: Int,
) : Party() {
    fun annualCost(): Int {
        return this.monthlyCost * 12
    }
}

class Department(
        private val monthlyCost: Int,
) : Party() {
    fun totalAnnualCost(): Int {
        return monthlyCost * 12
    }
}

open class FixedParty {
    fun annualCost(monthlyCost: Int): Int {
        return monthlyCost * 12
    }
}