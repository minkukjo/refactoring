package application.ch6

import domain.ch6.CommandLine
import domain.ch6.split.Order
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import kotlin.system.exitProcess

fun countOrders(commandLine: CommandLine, args: Array<String>): Int {
    val input = File(commandLine.fileName).readText(Charsets.UTF_8)
    val orders = Json.decodeFromString<Array<Order>>(input)
    return if (commandLine.onlyCountReady) {
        orders.count { item -> "ready" == item.status }
    } else {
        orders.size
    }
}

fun run(args: Array<String>): Int {
    if (args.isEmpty()) throw RuntimeException("파일명을 입력하세요!")
    val commandLine = CommandLine(onlyCountReady = args.any { arg -> "-r" == arg }, fileName = args[args.size - 1])
    return countOrders(commandLine, args)
}

fun main(args: Array<String>) {
    try {
        println(run(args))
    } catch (e: Exception) {
        System.err.println(e)
        exitProcess(1)
    }
}