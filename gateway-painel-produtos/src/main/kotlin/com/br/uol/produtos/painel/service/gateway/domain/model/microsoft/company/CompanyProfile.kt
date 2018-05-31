package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.company


import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others.Attributes

import java.io.Serializable

class CompanyProfile(domain: String?) : Serializable {
    private val MICROSOFT_DEFAULT_DOMAIN = ".onmicrosoft.com"
    var domain: String? = null

    //utilizados no response da requisição para adicionar um customer
    var tenantId: String? = null
    var attributes: Attributes? = null


    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

    init {
        var domain = domain
        if (domain != null && !domain.contains(MICROSOFT_DEFAULT_DOMAIN)) {
            domain += MICROSOFT_DEFAULT_DOMAIN
        }
        this.domain = domain
    }

}
