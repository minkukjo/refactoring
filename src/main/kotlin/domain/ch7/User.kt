package domain.ch7

class User(
        val name: String,
        val courses: MutableList<Course>
) {
    fun addCourse(aCourse: Course) {
        this.courses.add(aCourse)
    }

    fun removeCourse(aCourse: Course, fnIfAbsent: () -> Unit) {
        val index = courses.indexOf(aCourse)
        if (index == -1) fnIfAbsent()
        else courses.remove(aCourse)
    }
}