package application.ch7

import domain.ch7.Course
import domain.ch7.Person

fun main() {
    val basicCourseNames = arrayOf("harry", "denis", "jane")
    val aPerson = Person("test", arrayOf())
    aPerson.courses = basicCourseNames.map { name -> Course(name, false) }.toTypedArray()
}