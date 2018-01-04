package com.br.uol.produtos.painel.product.service

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix


@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
class ProductServiceApplication{

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(ProductServiceApplication::class.java, *args)
        }

    }
}

