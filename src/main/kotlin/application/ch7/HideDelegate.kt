package application.ch7

import domain.ch7.Department
import domain.ch7.Worker

fun main() {
    val aWorker = Worker("harry", Department("400", "sheldon"))
    val manager = aWorker.getManager()

}