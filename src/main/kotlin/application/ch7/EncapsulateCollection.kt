package application.ch7

import domain.ch7.Course
import domain.ch7.Person

fun main() {
    val basicCourseNames = arrayOf("harry", "denis", "jane")
    val aPerson = Person("test", mutableListOf())
    // 캡슐화가 깨졌다.
//    aPerson.courses = basicCourseNames.map { name -> Course(name, false) }.toTypedArray()

    // aPerson의 책임은 자신이 관리하는 Course를 관리하는 것
    basicCourseNames.forEach { name -> aPerson.addCourse(Course(name, false)) }
}