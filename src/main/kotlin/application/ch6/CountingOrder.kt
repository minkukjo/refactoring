package application.ch6

import domain.ch6.split.Order
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

fun run(args: Array<String>) {
    if (args.isEmpty()) throw RuntimeException("파일명을 입력하세요!")
    val fileName = args[args.size - 1]
    val input = File(fileName).readText(Charsets.UTF_8)
    val orders = Json.decodeFromString<Array<Order>>(input)
    if (args.any { arg -> "-r" == arg }) {
        println(orders.count { item -> "ready" == item.status })
    } else {
        println(orders.size)
    }
}

fun main(args: Array<String>) {
    try {
        run(args)
    } catch (e: Exception) {
        System.err.println(e)
        System.exit(1)
    }
}