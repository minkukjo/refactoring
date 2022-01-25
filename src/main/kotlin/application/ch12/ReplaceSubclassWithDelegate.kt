package application.ch12

// 12.10 서브클래스를 위임으로 바꾸기
// 상속의 문제를 위임으로 해결
// 상속보다는 컴포지션을 사용하라!
// 저자는 상속으로 일단 개발하고 후에 문제가 생기면 위임으로 갈아탄다고 한다. (태세전환 오졌고)

open class Booking(
        val show: String,
        val date: String,
) {
    private val isPeakDay: Boolean = true
    open fun hasTalkback(): Boolean {
        return isPeakDay
    }
}

class PremiumBooking(
        show: String,
        date: String,
) : Booking(show, date) {
    override fun hasTalkback(): Boolean {
        return true
    }

    private val isPeakDay: Boolean = true
    fun hasDinner(): Boolean {
        return isPeakDay
    }
}
