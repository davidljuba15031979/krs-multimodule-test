package com.nortal.krs.adapter.persistence

import com.nortal.krs.application.port.out.persistence.SaveCourse
import com.nortal.krs.domain.Course
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
open class SaveCourseAdapter @Autowired constructor(private var courseRepository: CourseRepository): SaveCourse {

    override fun save(course: Course): Course {
        val persistCourse = Course.create(course.name)
        val saved = courseRepository.save(persistCourse)
        return Course(saved.courseId, saved.name)
    }
}