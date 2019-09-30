package com.nortal

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

import java.security.Principal

@RestController
open class GreetController {

    @GetMapping("/")
    @PreAuthorize("hasRole('USER')")
    open fun greet(principal: Mono<Principal>): Mono<String> {
        return principal
                .map { it.name }
                .map { name -> String.format("Hello, %s", name) }
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    open fun greetAdmin(principal: Mono<Principal>): Mono<String> {
        return principal
                .map { it.name }
                .map { name -> String.format("Admin access: %s", name) }
    }
}
