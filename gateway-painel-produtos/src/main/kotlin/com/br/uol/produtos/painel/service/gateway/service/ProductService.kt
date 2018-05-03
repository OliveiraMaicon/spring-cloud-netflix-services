package com.br.uol.produtos.painel.service.gateway.service

import com.netflix.discovery.EurekaClient
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@RefreshScope
@Service
class ProductService {

    @Value("\${message.fallback}")
    lateinit var messageFallback: String

    @Autowired
    lateinit var restTemplate: RestTemplate

    @Autowired
    lateinit var discoveryClient: EurekaClient

    @HystrixCommand(fallbackMethod = "reliable")
    fun getProducts(): String {
        return this.restTemplate.getForObject(URI.create(serviceUrl() + "products"), String::class.java)
    }

    fun serviceUrl(): String {
        val instance = discoveryClient.getNextServerFromEureka("product-service", false)
        return instance.homePageUrl
    }

    fun reliable(): String {
        return messageFallback
    }

    @HystrixCommand(fallbackMethod = "reliable")
    fun teste(): String {
        return "ABACATE"
    }

}