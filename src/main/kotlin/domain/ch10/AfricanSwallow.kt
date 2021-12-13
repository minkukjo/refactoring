package domain.ch10

class AfricanSwallow(bird: Bird) : Bird(bird) {
    override fun plumage(): String {
        return if (this.numberOfCoconuts > 2) {
            "지쳤다"
        } else {
            "보통이다"
        }
    }

    override fun airSpeedVelocity(): Int {
        return 35 - 2 * this.numberOfCoconuts
    }
}