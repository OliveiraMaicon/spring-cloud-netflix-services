package com.br.uol.produtos.painel.service.turbine

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.cloud.netflix.turbine.EnableTurbine

@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
class TurbineServiceApplication{

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(TurbineServiceApplication::class.java, *args)
        }

    }

}
