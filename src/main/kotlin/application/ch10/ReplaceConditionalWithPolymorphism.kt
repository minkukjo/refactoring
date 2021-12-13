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
    return Bird(bird).plumage()
}

fun airSpeedVelocity(bird: Bird): Int { // 깃털 상태
    return Bird(bird).airSpeedVelocity()
}