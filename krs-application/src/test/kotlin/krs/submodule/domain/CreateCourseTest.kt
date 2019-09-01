/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package krs.submodule.domain

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import com.nortal.krs.submodule.Course
import com.nortal.krs.submodule.adapter.out.persistence.SaveCourse
import com.nortal.krs.submodule.domain.CreateCourse
import java.util.*

class CreateCourseTest : StringSpec() {

    @MockK
    lateinit var saveCourse: SaveCourse

    @InjectMockKs
    lateinit var createCourse: CreateCourse

    init {
        MockKAnnotations.init(this)

        "Create one course then one course created" {

            // given: prepare save method to return mock
            every { saveCourse.save(any()) } returns Course(UUID.randomUUID(), "Learn Kotlin")

            // when: create course
            val createdCourse = createCourse.createCourse(name = "Learn Kotlin")

            // then: course was created
            createdCourse.name shouldBe "Learn Kotlin"

        }
    }
}
