package com.br.uol.produtos.painel.service.gateway.endpoint

import com.br.uol.produtos.painel.service.gateway.domain.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @RequestMapping("/products")
    fun toRead(): String? {
        return productService.getProducts()
    }

    @RequestMapping("/teste")
    fun teste(): String {
        return productService.teste()
    }

}