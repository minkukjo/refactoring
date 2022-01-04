package application.ch11

import jdk.nashorn.internal.objects.Global.Infinity
import java.text.NumberFormat
import java.util.Locale

// 11.2 함수 매개변수화하기

fun usd(number: Int): String {
    return NumberFormat.getCurrencyInstance(Locale.US).format(number / 100)
}

fun usd(number: Double): String {
    return NumberFormat.getCurrencyInstance(Locale.US).format(number / 100)
}

fun withBand(usage: Long, bottom: Long, top: Long): Long {
    return if (usage > bottom) {
        usage.coerceAtMost(top) - bottom
    } else {
        0
    }
}

fun withBand(usage: Long, bottom: Long, top: Double): Long {
    return if (usage > bottom) {
        usage.coerceAtMost(top.toLong()) - bottom
    } else {
        0
    }
}

fun baseCharge(usage: Long): String {
    if (usage < 0) return usd(0)
    val amount =
            withBand(usage, 0, 100) * 0.03
    +withBand(usage, 100, 200) * 0.05
    +withBand(usage, 200, Infinity) * 0.07
    return usd(amount)
}