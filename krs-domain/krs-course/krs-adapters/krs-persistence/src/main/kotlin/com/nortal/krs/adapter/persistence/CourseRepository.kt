package com.nortal.krs.adapter.persistence

import com.nortal.krs.domain.Course
import com.nortal.krs.domain.CourseId
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, CourseId>
