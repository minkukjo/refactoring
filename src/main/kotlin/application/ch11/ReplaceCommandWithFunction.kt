package application.ch11

// 11.10 명령을 함수로 바꾸기
// 11.9와 완전히 반대되는 리팩토링 기법이다.

fun charge(baseRate: Int, usage: Int, connectionCharge: Int): Int {
    val baseCharge = baseRate * usage
    return baseCharge + connectionCharge
}


// 제거
@Deprecated(message = "Command에서 함수로 뽑아냈음")
class ChargeCalculator(
        val baseRate: Int,
        val usage: Int,
        val connectionCharge: Int,
) {
    fun baseCharge(): Int {
        return this.baseRate * this.usage
    }

    fun getCharge(baseRate: Int, usage: Int, connectionCharge: Int): Int {
        val baseCharge = baseRate * usage
        return baseCharge + connectionCharge
    }
}

fun main() {
    val chargeCalculator = ChargeCalculator(40, 20, 10)
}