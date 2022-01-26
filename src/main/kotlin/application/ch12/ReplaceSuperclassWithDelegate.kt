package application.ch12

// 12.11 슈퍼클래스를 위임으로 바꾸기

open class CatalogItem(
        val id: Long,
        val title: String,
        val tags: String,
)

class Scroll(id: Long, title: String, tags: String, val dateLastCleaned: String) : CatalogItem(id, title, tags) {

}