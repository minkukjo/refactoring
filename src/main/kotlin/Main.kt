import application.htmlStatement
import application.statement
import domain.ch1.Invoice
import domain.ch1.Play
import domain.ch4.Province
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File


fun getPlays(json: Json): Map<String, Play> {
    val playsJson = File("./src/main/resources/plays.json").readText(Charsets.UTF_8)
    return json.decodeFromString(playsJson)
}

fun getInvoices(json: Json): List<Invoice> {
    val invoicesJson = File("./src/main/resources/invoices.json").readText(Charsets.UTF_8)
    return json.decodeFromString(invoicesJson)
}

fun chapter1() {
    val json = Json {
        ignoreUnknownKeys = true
    }
    val plays = getPlays(json)
    val invoices = getInvoices(json)
    println(statement(invoices[0], plays))
    println(htmlStatement(invoices[0], plays))
}

fun getProvince(json: Json): Province {
    val provinceJson = File("./src/main/resources/province.json").readText(Charsets.UTF_8)
    return json.decodeFromString(provinceJson)
}

fun chapter2() {
    val json = Json {
        ignoreUnknownKeys = true
    }
    println(getProvince(json))
}

fun main() {

    chapter2()
}
