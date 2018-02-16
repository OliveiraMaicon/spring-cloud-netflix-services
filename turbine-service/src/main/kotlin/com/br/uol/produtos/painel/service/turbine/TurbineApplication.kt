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
/*@EnableAdminServer*/
class TurbineApplication {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(TurbineApplication::class.java, *args)
        }

    }

}
