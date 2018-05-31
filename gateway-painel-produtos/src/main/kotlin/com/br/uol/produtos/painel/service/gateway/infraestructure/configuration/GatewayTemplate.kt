package com.br.uol.produtos.painel.service.gateway.infraestructure.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GatewayTemplate {

    @Autowired
    private lateinit var gatewayRestTemplate: GatewayRestTemplate

   /* @Throws(BadRequestException::class)*/
    fun createRestTemplate(url: String): GatewayRestTemplate {
       gatewayRestTemplate.setUrl(url)
       return gatewayRestTemplate
    }

}