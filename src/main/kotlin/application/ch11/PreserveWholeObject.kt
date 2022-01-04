package application.ch11

import domain.ch11.HeatingPlan
import domain.ch11.Room
import domain.ch11.TempRange

fun main() {
    val daysTempRange = TempRange(10, 50)
    val aRoom = Room(daysTempRange)
    val low = aRoom.daysTempRange.low
    val high = aRoom.daysTempRange.high
    val aHeatingPlan = HeatingPlan(daysTempRange)
    if (!aHeatingPlan.withRange(aRoom.daysTempRange)) {
        println("방 온도가 지정 범위를 벗어났습니다")
    }

}