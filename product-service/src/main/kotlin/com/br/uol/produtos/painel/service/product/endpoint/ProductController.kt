package com.br.uol.produtos.painel.service.product.endpoint

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {

    @RequestMapping(value = ["/products"])
    fun productList(): ResponseEntity<String> {
        return ResponseEntity.ok(listOf(19, 140).toString())
    }


}