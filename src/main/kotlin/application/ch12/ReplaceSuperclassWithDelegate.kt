package application.ch12

// 12.11 슈퍼클래스를 위임으로 바꾸기

open class CatalogItem(
        val id: Long,
        val title: String,
        val tags: String,
)

class Scroll(
        val id: Long,
        val title: String,
        val tags: String,
        val dateLastCleaned: String,
        val catalogItem: CatalogItem = CatalogItem(id, title, tags)
)