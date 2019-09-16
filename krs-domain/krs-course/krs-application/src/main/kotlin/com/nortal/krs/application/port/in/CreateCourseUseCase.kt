package com.nortal.krs.application.port.`in`

import com.nortal.krs.domain.Course


interface CreateCourseUseCase {

    fun createCourse(name: String): Course
}
