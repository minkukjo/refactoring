package application.ch10

import domain.ch10.AfricanSwallow
import domain.ch10.Bird
import domain.ch10.EuropeanSwallow
import domain.ch10.NorwegianBlueParrot

// 10.4 조건부 로직을 다형성으로 바꾸기
// 아무래도 이번 챕터 가장 중요한 내용이 아닐까 싶음
// 모든 조건문을 다형성으로 바꿔야하는 것은 아니다.
// 그러나 복잡한 조건부 로직은 다형성이 막강한 도구임은 확실하다.

fun plumages(birds: List<Bird>): Map<String, List<String>> {
    return birds
            .map { b -> createBird(b) }
            .groupBy({ b -> b.name }, { b -> plumage(b) })
}

fun speeds(birds: List<Bird>): Map<String, List<Int>> {
    return birds
            .map { b -> createBird(b) }
            .groupBy({ b -> b.name }, { b -> airSpeedVelocity(b) })
}

fun createBird(bird: Bird): Bird {
    return when (bird.type) {
        "유럽 제비" -> EuropeanSwallow(bird)
        "아프리카 제비" -> AfricanSwallow(bird)
        "노르웨이 파랑 앵무" -> NorwegianBlueParrot(bird)
        else -> throw Exception("존재하지 않는 새 입니다.")
    }
}

fun plumage(bird: Bird): String { // 깃털 상태
    return Bird(bird).plumage()
}

fun airSpeedVelocity(bird: Bird): Int { // 깃털 상태
    return Bird(bird).airSpeedVelocity()
}