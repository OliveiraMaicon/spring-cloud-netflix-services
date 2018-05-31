package com.br.uol.produtos.painel.service.gateway.domain.repository.microsoft

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.customer.Customer

interface IMicrosoftRepository {

    fun findCustomerById(id : String) : Customer?

}