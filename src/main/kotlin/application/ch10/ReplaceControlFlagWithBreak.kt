package application.ch10

// 10.7 제어 플래그를 탈출문으로 바꾸기 하하
// 좋은 내용이었다. 후후

fun findMiscreant() {
    val peoples = listOf("좋은 사람", "악당", "아주 나쁜 놈이지만 악당은 아님", "사루만", "조커")
    for (p in peoples) {
        if (p == "조커") {
            sendAlert()
            return
        }
        if (p == "사루만") {
            sendAlert()
            return
        }
    }
}

fun sendAlert() {
    TODO("Not yet implemented")
}
