package application.ch12

// 12.10 서브클래스를 위임으로 바꾸기
// 상속의 문제를 위임으로 해결
// 상속보다는 컴포지션을 사용하라!
// 저자는 상속으로 일단 개발하고 후에 문제가 생기면 위임으로 갈아탄다고 한다. (태세전환 오졌고)

open class Booking(
        val show: String,
        val date: String,
        val extras: String = "",
) {
    private val isPeakDay: Boolean = true

    var premiumBookingDelegate: PremiumBookingDelegate? = null

    open fun hasTalkback(): Boolean {
        return premiumBookingDelegate?.hasTalkback() ?: this.isPeakDay
    }

    fun bePremium(extras: String) {
        this.premiumBookingDelegate = PremiumBookingDelegate(this, extras)
    }

    fun hasDinner(): Boolean? {
        return premiumBookingDelegate?.hasTalkback() ?: null
    }
}

class PremiumBookingDelegate(
        val host: Booking,
        val extras: String
) {
    fun hasTalkback(): Boolean {
        return true
    }
}

fun createBooking(show: String, date: String): Booking {
    return Booking(show, date)
}

fun createPremiumBooking(show: String, date: String, extras: String): Booking {
    val premiumBooking = Booking(show, date, extras)
    premiumBooking.bePremium(extras)
    return premiumBooking
}

fun main() {
    val aBooking = Booking("123", "2022-01-25")
    val aPremiumBooking = Booking("12434", "2022-01-25", "vip")
}
