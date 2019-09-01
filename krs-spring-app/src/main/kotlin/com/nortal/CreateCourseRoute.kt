package com.nortal

import com.nortal.krs.submodule.domain.CreateCourseUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class CreateCourseRoute(private val useCase: CreateCourseUseCase) {

    @Bean
    fun basicRoutes() = router {
        POST("/course") { ServerResponse.ok().body(fromObject(useCase.createCourse("Kotlin learn with Spring"))) }
        GET("/course") { ServerResponse.ok().body(fromObject(useCase.createCourse("Kotlin learn with Spring"))) }
    }
}