package application.ch11

// 11.6 질의 함수를 매개변수로 바꾸기
// 11.5의 리팩터링과 반대의 리팩터링이다.
// 그러나 저자는 이 리팩터링 보다는 호출자가 단순해지는 11.5의 리팩토링을 더 선호한다고 밝혔다.
// 여기서 이 리팩토링을 하는 이유는 함수 내에서 전역 변수를 사용하면서 참조 투명성을 잃게 되는 문제를 해결하기 위함이다.

// Thermostat : 온도 조절기
class Thermostat(
        val selectedTemperature: Long,
        val currentTemperature: Long,
)

val thermostat: Thermostat = Thermostat(20, 30)

class HeatingPlan(
        val max: Long,
        val min: Long,
) {
    fun targetTemperature(selectedTemperature: Long): Long {
        return if (selectedTemperature > this.max) this.max
        else if (selectedTemperature < this.min) this.min
        else selectedTemperature
    }
}


fun main() {
    val thePlan = HeatingPlan(50, 10)
    if (thePlan.targetTemperature(thermostat.selectedTemperature) > thermostat.currentTemperature) {
        setToHeat()
    } else if (thePlan.targetTemperature(thermostat.selectedTemperature) < thermostat.currentTemperature) {
        setToCool()
    } else {
        setOff()
    }
}

fun setOff() {
    TODO("Not yet implemented")
}

fun setToCool() {
    TODO("Not yet implemented")
}

fun setToHeat() {
    TODO("Not yet implemented")
}
