package application.ch8

import domain.ch8.Office

// 8.8 반복문을 파이프라인으로 바꾸기

fun acquireData(input: String): List<Office> {
    val lines = input.split("\n")
    var firstLine = true
    var result = mutableListOf<Office>()
    for (line in lines) {
        if (firstLine) {
            firstLine = false
            continue
        }
        if (line.trim() == "") continue
        val record = line.split(",")
        if (record[1].trim() == "India") {
            result.add(Office(office = record[0].trim(), country = record[1].trim(), telephone = record[2].trim()))
        }
    }
    return result
}

fun main() {
    val input = """
        office,country,telephone
        Chicago,USA,+1 312 373 1000
        Beijing,China,+86 4008 900 505
        Bangalore,India,+91 80 4064 9570
        Porto Alegre,Brazil,+55 51 3079 3550
        Chennai,India,+91 44 660 44766
    """.trimIndent()
    val acquireData = acquireData(input)
    acquireData.forEach {
        println("${it.office} ${it.country} ${it.telephone}")
    }

}