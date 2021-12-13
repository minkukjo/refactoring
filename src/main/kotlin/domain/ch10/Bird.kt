package domain.ch10

open class Bird(
        val name: String,
        val type: String,
        val numberOfCoconuts: Int,
        val voltage: Int,
        val isNailed: Boolean,
) {
    constructor(bird: Bird) : this(bird.name, bird.type, bird.numberOfCoconuts, bird.voltage, bird.isNailed) {
    }

    open fun plumage(): String {
        return "알 수 없다."
    }


    open fun airSpeedVelocity(): Int {
        return -1
    }
}