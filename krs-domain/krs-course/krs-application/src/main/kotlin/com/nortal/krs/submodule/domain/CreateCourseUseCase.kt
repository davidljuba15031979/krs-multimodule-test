package com.nortal.krs.submodule.domain

import com.nortal.krs.submodule.Course

interface CreateCourseUseCase {

    fun createCourse(name: String): Course
}
