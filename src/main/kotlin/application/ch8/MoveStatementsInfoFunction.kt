package application.ch8

// 문장을 함수로 옮기기

fun photoDiv(photo: Photo): String {
    return """
        <div>
            ${emitPhotoData(photo)}
        </div>
    """.trimIndent()
}

fun emitPhotoData(photo: Photo) = """
            <p>제목: ${photo.title}</p>
            <p>위치: ${photo.location}</p>
            <p>날짜: ${photo.date}</p>
            """.trimIndent()

fun renderPerson(person: Person): String {
    return """
        <p>${person.name}</p>
        ${renderPhoto(person.photo)}
        <p>제목:${person.photo.title}</p>
        ${emitPhotoData(person.photo)}
    """.trimIndent()
}

fun renderPhoto(photo: Photo): String {
    TODO("Not yet implemented")
}
