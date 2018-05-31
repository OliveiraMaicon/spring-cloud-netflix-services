package com.br.uol.produtos.painel.service.gateway.domain.service.microsoft

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.customer.Customer

interface IMicrosoftService {
    fun getCustomer(customerId: String): Customer
}