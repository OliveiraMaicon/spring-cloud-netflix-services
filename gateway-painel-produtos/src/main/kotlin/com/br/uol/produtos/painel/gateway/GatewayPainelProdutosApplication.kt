package com.br.uol.produtos.painel.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@EnableCircuitBreaker
@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
class GatewayPainelProdutosApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(GatewayPainelProdutosApplication::class.java, *args)
        }

    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}

