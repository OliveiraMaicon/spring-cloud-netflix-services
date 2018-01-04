package com.br.uol.produtos.painel.product.service.endpoint

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping


@RestController
class ProductController {

    @RequestMapping(value = "/products")
    fun readingList(): ResponseEntity<String> {
        return ResponseEntity.ok(listOf(19, 140).toString())
    }


}