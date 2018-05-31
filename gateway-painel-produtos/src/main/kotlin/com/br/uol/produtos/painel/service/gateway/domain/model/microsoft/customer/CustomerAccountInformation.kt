package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.customer

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.address.Address

import java.io.Serializable

class CustomerAccountInformation : Serializable {
    var businessName: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var address: Address? = null
    var communicationLanguage: String? = null
    var communicationCulture: String? = null

    companion object {
        private const val serialVersionUID = 5009698424459854428L
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CustomerAccountInformation

        if (businessName != other.businessName) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (address != other.address) return false
        if (communicationLanguage != other.communicationLanguage) return false
        if (communicationCulture != other.communicationCulture) return false

        return true
    }

    override fun hashCode(): Int {
        var result = businessName?.hashCode() ?: 0
        result = 31 * result + (firstName?.hashCode() ?: 0)
        result = 31 * result + (lastName?.hashCode() ?: 0)
        result = 31 * result + (address?.hashCode() ?: 0)
        result = 31 * result + (communicationLanguage?.hashCode() ?: 0)
        result = 31 * result + (communicationCulture?.hashCode() ?: 0)
        return result
    }
}
