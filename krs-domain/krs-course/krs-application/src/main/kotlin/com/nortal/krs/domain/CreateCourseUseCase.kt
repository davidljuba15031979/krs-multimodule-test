package com.nortal.krs.domain


interface CreateCourseUseCase {

    fun createCourse(name: String): Course
}
