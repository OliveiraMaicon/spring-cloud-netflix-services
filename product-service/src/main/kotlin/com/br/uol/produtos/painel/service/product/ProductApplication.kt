package com.br.uol.produtos.painel.service.product

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix

@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
class ProductApplication {

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(ProductApplication::class.java, *args)
        }

    }
}
