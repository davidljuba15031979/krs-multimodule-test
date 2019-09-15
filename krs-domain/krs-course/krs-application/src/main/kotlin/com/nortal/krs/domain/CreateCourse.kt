package com.nortal.krs.domain

import com.nortal.krs.application.port.out.persistence.SaveCourse
import org.springframework.stereotype.Service


@Service
class CreateCourse(private val saveCourse: SaveCourse): CreateCourseUseCase {

    override fun createCourse(name: String): Course {
        return saveCourse.save(Course.create(name))
    }
}