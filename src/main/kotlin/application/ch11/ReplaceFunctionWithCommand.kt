package application.ch11

// 11.9 함수를 명령으로 바꾸기
// 자바에서는 함수라는 개념이 없지만, 자바스크립트나 코틀린에서는 함수를 객체의 메서드로 갖게 할 수 있다.
// 여기서는 Command Object, Command라고 부른다고 함.
// 그러나 저자는 일급 함수와 Command 중 하나를 선택하라면 95% 일급 함수를 택한다고 하니 참고.

fun score(candidate: String, medicalExam: String, scoringGuid: String) {
    // 대충 긴 코드
}


class Scorer(
        val candidate: String,
        val medicalExam: String,
        val scoringGuid: String
) {
    fun execute() {
        // 대충 긴 코드
    }
}