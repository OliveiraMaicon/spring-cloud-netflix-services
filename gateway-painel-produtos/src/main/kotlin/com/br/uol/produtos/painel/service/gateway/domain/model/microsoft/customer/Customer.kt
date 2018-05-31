package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.customer

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.company.CompanyProfile
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others.Attributes
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.user.UserCredentials
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.billing.BillingProfile
import java.io.Serializable

class Customer(customer: CustomerAccountInformation, subdomain: String, email: String) : Serializable {

    var companyProfile: CompanyProfile? = null
    var billingProfile: BillingProfile? = null
    var id: String? = null
    var commerceId: String? = null
    var relationshipToPartner: String? = null
    var userCredentials: UserCredentials? = null
    var attributes: Attributes? = null

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

    init {
        this.companyProfile = CompanyProfile(subdomain)
        this.billingProfile = BillingProfile(customer, email)
    }
}