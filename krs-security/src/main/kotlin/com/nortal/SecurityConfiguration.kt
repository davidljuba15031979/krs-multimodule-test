package com.nortal

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.web.reactive.config.EnableWebFlux

/**
 * https://www.baeldung.com/spring-security-5-reactive
 * https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
 * https://auth0.com/blog/securing-spring-boot-apis-and-spas-with-oauth2/
 * https://www.baeldung.com/spring-security-method-security
 *
 */
//@EnableWebFlux
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity

open class SecurityConfiguration {

    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    @Bean
    open fun securitygWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http.authorizeExchange()
                .anyExchange().authenticated()
                .and().formLogin()
//                .and().oauth2Login()
                .and().build()
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }


    @Bean
    open fun userDetailsService(): MapReactiveUserDetailsService {
        val user = User
                .withUsername("user")
                .password(passwordEncoder!!.encode("password"))
                .roles("USER")
                .build()
        val admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .build()
        return MapReactiveUserDetailsService(user, admin)
    }
}

