package domain.ch10

class EuropeanSwallow(bird: Bird) : Bird(bird) {
    override fun plumage(): String {
        return "보통이다"
    }

    override fun airSpeedVelocity(): Int {
        return 35
    }
}