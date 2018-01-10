package com.br.uol.produtos.painel.config.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer

@EnableConfigServer
@SpringBootApplication
class ConfigServerApplication{

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(ConfigServerApplication::class.java, *args)
        }

    }

}

