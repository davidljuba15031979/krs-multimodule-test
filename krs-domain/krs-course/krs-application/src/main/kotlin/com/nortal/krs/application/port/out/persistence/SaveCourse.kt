package com.nortal.krs.application.port.out.persistence

import com.nortal.krs.domain.Course

interface SaveCourse {

    fun save(course: Course): Course
}