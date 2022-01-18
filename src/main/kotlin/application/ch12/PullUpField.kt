package application.ch12

// 12.2 필드 올리기
// 12.1과 유사하나, 함수가 아닌 필드를 올리는 기법

open class Party2

class Employee2(
        private val monthlyCost: Int,
) : Party() {

}

class Department2(
        private val monthlyCost: Int,
) : Party() {

}

open class FixedParty2(
        private val monthlyCost: Int,
) {

}