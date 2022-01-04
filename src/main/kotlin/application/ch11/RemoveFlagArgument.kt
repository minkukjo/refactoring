package application.ch11

// 11.3 플래그 인수 제거하기

fun bookConcert(aCustomer: Any, isPremium: Boolean) {
    if (isPremium) {
        // 프리미엄 예약용 로직
    } else {
        // 일반 예약용직로직
    }
}

// 아래와 같이 로직 수정

fun premiumBookConcert(aCustomer: Any) {
    
}