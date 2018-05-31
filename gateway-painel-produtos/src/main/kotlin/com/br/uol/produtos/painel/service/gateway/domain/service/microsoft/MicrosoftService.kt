package com.br.uol.produtos.painel.service.gateway.domain.service.microsoft

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.customer.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class MicrosoftService : IMicrosoftService{

    @Autowired
    private lateinit var restTemplate: RestTemplate

    override fun getCustomer(customerId: String): Customer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
