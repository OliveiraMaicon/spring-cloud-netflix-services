package com.br.uol.produtos.painel.eureka.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class EurekaServerApplication{
    companion object {

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(EurekaServerApplication::class.java, *args)
        }

    }


}
