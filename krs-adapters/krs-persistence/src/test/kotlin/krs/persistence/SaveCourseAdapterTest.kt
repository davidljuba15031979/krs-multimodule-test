package krs.persistence

import com.nortal.krs.adapter.persistence.CourseRepository
import com.nortal.krs.submodule.Course
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataMongoTest
//@DataJpaTest
//@SpringBootTest(classes = [CourseRepository::class])
//@DataMongoTest
@SpringBootConfiguration
@EnableAutoConfiguration
//@ComponentScan
open class SaveCourseAdapterTest/* : StringSpec() */{
//    https://dev.to/kerooker/testing-a-spring-boot-application-with-kotlintest-pgd
//    override fun listeners() = listOf(SpringListener)

    @Autowired
    private lateinit var courseRepository: CourseRepository

//    init {
//
//
//    }

    @Test
    internal fun name() {
        courseRepository.save(Course.create("dada"))
    }
}