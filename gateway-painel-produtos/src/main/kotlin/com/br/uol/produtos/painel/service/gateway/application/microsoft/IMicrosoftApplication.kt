package com.br.uol.produtos.painel.service.gateway.application.microsoft

interface IMicrosoftApplication {

    fun getCustomer(customerId: String): String
}