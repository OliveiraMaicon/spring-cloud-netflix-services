package com.br.uol.produtos.painel.service.gateway.endpoint.microsoft

import com.br.uol.produtos.painel.service.gateway.application.microsoft.IMicrosoftApplication
import org.apache.http.HttpException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/microsoft")
class MicrosoftController {

    @Autowired
    private lateinit var microsoftApplication: IMicrosoftApplication


    @RequestMapping("/customers/{customerId}")
    fun getCustomer(@PathVariable customerId: String): ResponseEntity<*> {
        return try {
            ResponseEntity.ok(microsoftApplication.getCustomer(customerId))
        } catch (e: HttpException) {
            ResponseEntity.badRequest().body(/*BadRequestException(null, e)*/"")
        }

    }

}