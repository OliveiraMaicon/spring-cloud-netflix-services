package com.br.uol.produtos.painel.service.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@EnableCircuitBreaker
@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
class GatewayApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(GatewayApplication::class.java, *args)
        }

    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}
