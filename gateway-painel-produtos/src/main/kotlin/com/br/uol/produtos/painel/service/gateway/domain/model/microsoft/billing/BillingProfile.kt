package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.billing

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others.Attributes
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others.DefaultAddress
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.address.Address
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.customer.CustomerAccountInformation

import java.io.Serializable

class BillingProfile
/**
 * Construtor para criar um novo customer
 *
 * @param customer
 * @param email
 */(customer: CustomerAccountInformation, email: String) : Serializable {

    var id: String? = null
    var email: String? = email
    var culture: String? = null
    var language: String? = null
    var companyName: String? = null
    var defaultAddress: DefaultAddress? = null

    // utilizados no response da requisição para adicionar um customer
    var attributes: Attributes? = null


    fun parseToCustomerAccountInformation(): CustomerAccountInformation {
        val account = CustomerAccountInformation()
        var address: Address? = null

        if (defaultAddress != null) {
            address = defaultAddress!!.parseToAddress()
            account.firstName = defaultAddress!!.firstName
            account.lastName = defaultAddress!!.lastName
        }

        account.address = address
        account.businessName = companyName
        account.communicationLanguage = language
        account.communicationCulture = culture

        return account
    }

    fun parseBillingProfileInfo(mosiProfile: CustomerAccountInformation) {

        this.defaultAddress = DefaultAddress(mosiProfile.firstName, mosiProfile.lastName,
                mosiProfile.address)

        this.companyName = mosiProfile.businessName

        if (mosiProfile.communicationCulture != null) {
            this.culture = mosiProfile.communicationCulture
        }

        if (mosiProfile.communicationLanguage != null) {
            this.language = mosiProfile.communicationLanguage
        }
    }

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

    init {
        val language = customer.communicationLanguage
        val culture = customer.communicationCulture
        this.companyName = customer.businessName
        this.defaultAddress = DefaultAddress(customer.firstName, customer.lastName,
                customer.address)
        this.language = language ?: "PT-BR"
        this.culture = culture ?: "pt-BR"
    }
}
