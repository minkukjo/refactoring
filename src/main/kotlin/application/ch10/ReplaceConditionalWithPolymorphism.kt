package application.ch10

import domain.ch10.Bird

// 10.4 조건부 로직을 다형성으로 바꾸기
// 아무래도 이번 챕터 가장 중요한 내용이 아닐까 싶음
// 모든 조건문을 다형성으로 바꿔야하는 것은 아니다.
// 그러나 복잡한 조건부 로직은 다형성이 막강한 도구임은 확실하다.

fun plumages(birds: List<Bird>): Map<String, List<String>> {
    return birds.groupBy({ b -> b.name }, { b -> plumage(b) })
}

fun speeds(birds: List<Bird>): Map<String, List<Int>> {
    return birds.groupBy({ b -> b.name }, { b -> airSpeedVelocity(b) })
}

fun plumage(bird: Bird): String { // 깃털 상태
    return when (bird.type) {
        "유럽 제비" -> "보통이다"
        "아프리카 제비" -> if (bird.numberOfCoconuts > 2) {
            "지쳤다"
        } else {
            "보통이다"
        }
        "노르웨이 파랑 앵무" -> if (bird.voltage > 100) {
            "그을렸다"
        } else {
            "예쁘다"
        }
        else -> "알 수 없다."
    }
}

fun airSpeedVelocity(bird: Bird): Int { // 깃털 상태
    return when (bird.type) {
        "유럽 제비" -> 35
        "아프리카 제비" -> 35 - 2 * bird.numberOfCoconuts
        "노르웨이 파랑 앵무" -> if (bird.isNailed) {
            0
        } else {
            10 + bird.voltage / 10
        }
        else -> -1
    }
}