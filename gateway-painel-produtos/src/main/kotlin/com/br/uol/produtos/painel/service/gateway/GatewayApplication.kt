package com.br.uol.produtos.painel.service.gateway

import org.apache.http.client.config.RequestConfig
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.context.annotation.Bean
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
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


    @Bean
    @Qualifier("poolingHttpClientRequestFactory")
    fun httpComponentsClientHttpRequestFactory(): ClientHttpRequestFactory {
        val httpClientBuilder = HttpClientBuilder.create()
        val requestConfig = RequestConfig.custom().setConnectTimeout(30000)
                .setSocketTimeout(30000).build()
        httpClientBuilder.setDefaultRequestConfig(requestConfig)
        val connManager = PoolingHttpClientConnectionManager()
        connManager.defaultMaxPerRoute = 10
        connManager.maxTotal = 150
        httpClientBuilder.setConnectionManager(connManager)
        return HttpComponentsClientHttpRequestFactory(
                httpClientBuilder.build())
    }
}
