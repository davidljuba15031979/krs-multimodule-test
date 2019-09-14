package com.nortal.krs.submodule.adapter.out.persistence

import com.nortal.krs.submodule.Course

interface SaveCourse {

    fun save(course: Course): Course
}