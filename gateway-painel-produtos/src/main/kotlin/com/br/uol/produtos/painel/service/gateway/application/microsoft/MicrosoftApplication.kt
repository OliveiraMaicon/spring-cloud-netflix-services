package com.br.uol.produtos.painel.service.gateway.application.microsoft

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.customer.Customer
import com.br.uol.produtos.painel.service.gateway.domain.repository.microsoft.IMicrosoftRepository
import com.br.uol.produtos.painel.service.gateway.domain.service.microsoft.IMicrosoftService
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MicrosoftApplication : IMicrosoftApplication {

    @Autowired
    private lateinit var microsoftService: IMicrosoftService

    @Autowired
    private lateinit var microsoftRepository: IMicrosoftRepository

    @HystrixCommand(fallbackMethod = "failGetCustomer")
    override fun getCustomer(customerId: String): String {

        //TODO verify in database

        var customer: Customer?

        customer = microsoftRepository.findCustomerById(customerId)

        if( customer == null){
            customer = microsoftService.getCustomer(customerId)
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun failGetCustomer() : String{
        return "Api de customer indisponivel no momento."
    }


}