package com.nortal.krs.submodule

import java.util.*


class Course(
        val courseId: CourseId,
        val name: String
) {
    companion object Factory {
        fun create(name: String): Course = Course(UUID.randomUUID(), name)
    }
}
