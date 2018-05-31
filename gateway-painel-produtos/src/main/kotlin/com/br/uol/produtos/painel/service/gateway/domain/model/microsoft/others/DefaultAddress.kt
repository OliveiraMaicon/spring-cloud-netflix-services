package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.address.Address
import java.io.Serializable


class DefaultAddress(firstName: String?, lastName: String?, address: Address?) : Serializable {

    var country: String? = null
    var region: String? = null
    var city: String? = null
    var state: String? = null
    var addressLine1: String? = null
    var addressLine2: String? = null
    var postalCode: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var phoneNumber: String? = null


    /**
     * Transforma DefaultAddress (CSP) em um Address (MOSI)
     * @return
     */
    fun parseToAddress(): Address {
        val addressMosi = Address()

        addressMosi.state = state
        addressMosi.phoneNumber = if (phoneNumber != null) phoneNumber!!.toString() else null
        addressMosi.city = city
        addressMosi.postalCode = postalCode
        addressMosi.line1 = addressLine1
        addressMosi.iso3CountryCode = country
        addressMosi.line2 = addressLine2

        return addressMosi
    }

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

    init {
        if (address != null) {
            this.city = address.city
            this.state = address.state
            this.addressLine1 = address.line1
            this.addressLine2 = address.line2
            this.postalCode = address.postalCode

            if (address.phoneNumber != null && address.phoneNumber != "") {
                this.phoneNumber = address.phoneNumber?.trim { it <= ' ' }?.replace("\\D".toRegex(), "")
            }

            if (address.iso3CountryCode != null) {
                this.country = address.iso3CountryCode?.substring(0, 2)?.toUpperCase()
            }

            this.firstName = firstName
            this.lastName = lastName
            this.region = "BR"
        }
    }
}
