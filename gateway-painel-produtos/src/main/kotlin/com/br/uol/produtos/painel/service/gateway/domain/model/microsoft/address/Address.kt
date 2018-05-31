package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.address

import java.io.Serializable

class Address : Serializable {
    var line1: String? = null
    var city: String? = null
    var state: String? = null
    var postalCode: String? = null
    var iso3CountryCode: String? = null
    var phoneNumber: String? = null
    var line2: String? = null

    companion object {
        private const val serialVersionUID = -5638572503215171981L
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (line1 != other.line1) return false
        if (city != other.city) return false
        if (state != other.state) return false
        if (postalCode != other.postalCode) return false
        if (iso3CountryCode != other.iso3CountryCode) return false
        if (phoneNumber != other.phoneNumber) return false
        if (line2 != other.line2) return false

        return true
    }

    override fun hashCode(): Int {
        var result = line1?.hashCode() ?: 0
        result = 31 * result + (city?.hashCode() ?: 0)
        result = 31 * result + (state?.hashCode() ?: 0)
        result = 31 * result + (postalCode?.hashCode() ?: 0)
        result = 31 * result + (iso3CountryCode?.hashCode() ?: 0)
        result = 31 * result + (phoneNumber?.hashCode() ?: 0)
        result = 31 * result + (line2?.hashCode() ?: 0)
        return result
    }

}
