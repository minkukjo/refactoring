package application.ch12

// 12.8 슈퍼 클래스 추출하기
// 비슷한 일을 수행하는 두 클래스가 있으면 상속 메커니즘을 이용해 비슷한 부분을 슈퍼 클래스로 옮겨올 수 있다.
// 개인적으로는 상속보다는 구현을 사용하는 편이 더 낫다고 생각한다.

interface Party3 {
    fun getAnnualCost() {

    }
}

class Department3() : Party3 {
    override fun getAnnualCost() {

    }
}

class Employee4() : Party3 {
    override fun getAnnualCost() {

    }
}