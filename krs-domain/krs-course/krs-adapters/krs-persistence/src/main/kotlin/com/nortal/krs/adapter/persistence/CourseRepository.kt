package com.nortal.krs.adapter.persistence

import com.nortal.krs.submodule.CourseId
import com.nortal.krs.submodule.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, CourseId>
