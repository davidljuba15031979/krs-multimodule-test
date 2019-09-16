package com.nortal.krs.adapter.web

import com.nortal.krs.application.port.`in`.CreateCourseUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
@EnableWebFlux
open class CreateCourseRoute(private val useCase: CreateCourseUseCase) {

    @Bean
    open fun basicRoutes() = router {
        POST("/course") { ServerResponse.ok().body(fromObject(useCase.createCourse("Kotlin learn with Spring"))) }
        GET("/course") { ServerResponse.ok().body(fromObject(useCase.createCourse("Kotlin learn with Spring"))) }
    }
}