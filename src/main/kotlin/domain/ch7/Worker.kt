package domain.ch7

class Worker(
        val name: String,
        val department: Department
) {
    fun getManager(): String {
        return this.department.manager
    }
}