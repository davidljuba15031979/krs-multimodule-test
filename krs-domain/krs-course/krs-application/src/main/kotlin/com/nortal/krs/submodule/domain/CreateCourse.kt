package com.nortal.krs.submodule.domain

import com.nortal.krs.submodule.Course
import com.nortal.krs.submodule.adapter.out.persistence.SaveCourse
import org.springframework.stereotype.Service


@Service
class CreateCourse(private val saveCourse: SaveCourse): CreateCourseUseCase {

    override fun createCourse(name: String): Course {
        return saveCourse.save(Course.create(name))
    }
}