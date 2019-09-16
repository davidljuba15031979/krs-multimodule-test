package com.nortal.krs.application.service

import com.nortal.krs.domain.Course
import com.nortal.krs.application.port.`in`.CreateCourseUseCase
import com.nortal.krs.application.port.out.SaveCourse
import org.springframework.stereotype.Service


@Service
class CreateCourse(private val saveCourse: SaveCourse): CreateCourseUseCase {

    override fun createCourse(name: String): Course {
        return saveCourse.save(Course.create(name))
    }
}