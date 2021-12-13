package domain.ch10

class NorwegianBlueParrot(bird: Bird) : Bird(bird) {
    override fun plumage(): String {
        return if (this.voltage > 100) {
            "그을렸다"
        } else {
            "예쁘다"
        }
    }

    override fun airSpeedVelocity(): Int {
        return if (this.isNailed) {
            0
        } else {
            10 + this.voltage / 10
        }
    }
}