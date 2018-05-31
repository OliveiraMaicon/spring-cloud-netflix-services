package com.br.uol.produtos.painel.service.gateway.domain.repository.microsoft

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.customer.Customer
import com.br.uol.produtos.painel.service.gateway.infraestructure.configuration.GatewayRestTemplate
import com.br.uol.produtos.painel.service.gateway.infraestructure.configuration.GatewayTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class MicrosoftRepository : IMicrosoftRepository {

    @Autowired
    private lateinit var gatewayTemplate: GatewayTemplate

    override fun findCustomerById(id: String): Customer? {

        val url = "http://gateway.csp.intranet/customers/$id"
        var retorno = gatewayTemplate.createRestTemplate(url)
                .setWeakHeaders()
                .get(Customer.javaClass).body
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}