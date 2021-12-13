package domain.ch10

class Bird(
        val name: String,
        val type: String,
        val numberOfCoconuts: Int,
        val voltage: Int,
        val isNailed: Boolean,
) {
    constructor(bird: Bird) : this(bird.name, bird.type, bird.numberOfCoconuts, bird.voltage, bird.isNailed) {
    }

    fun plumage(): String {
        return when (this.type) {
            "유럽 제비" -> "보통이다"
            "아프리카 제비" -> if (this.numberOfCoconuts > 2) {
                "지쳤다"
            } else {
                "보통이다"
            }
            "노르웨이 파랑 앵무" -> if (this.voltage > 100) {
                "그을렸다"
            } else {
                "예쁘다"
            }
            else -> "알 수 없다."
        }
    }


    fun airSpeedVelocity(): Int {
        return when (this.type) {
            "유럽 제비" -> 35
            "아프리카 제비" -> 35 - 2 * this.numberOfCoconuts
            "노르웨이 파랑 앵무" -> if (this.isNailed) {
                0
            } else {
                10 + this.voltage / 10
            }
            else -> -1
        }
    }
}