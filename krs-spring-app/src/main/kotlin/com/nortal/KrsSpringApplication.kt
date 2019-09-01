package com.nortal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
@EnableMongoRepositories
class KrsSpringApplication

fun main(args: Array<String>) {
    runApplication<KrsSpringApplication>(*args)
}
