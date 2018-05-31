package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.offer


import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.category.Category
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others.Attributes
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.product.Product

import java.io.Serializable

class TargetOffer : Serializable {

    var id: String? = null
    var name: String? = null
    var description: String? = null
    var minimumQuantity: Int? = null
    var maximinQuantity: Int? = null
    var rank: Int? = null
    var uri: String? = null
    var locale: String? = null
    var country: String? = null
    var category: Category? = null
    var isAddon: Boolean? = null
    var isAvailableForPurchase: Boolean? = null
    var billing: String? = null
    var isAutoRenewable: Boolean? = null
    var isInternal: Boolean? = null
    var partnerQualifications: List<String>? = null
    var product: Product? = null
    var unitType: String? = null
    var attributes: Attributes? = null

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (id == null) 0 else id!!.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (javaClass != other.javaClass)
            return false
        val other = other as TargetOffer?
        if (id == null) {
            if (other!!.id != null)
                return false
        } else if (id != other!!.id)
            return false
        return true
    }

    override fun toString(): String {
        return "TargetOffer [id=$id, name=$name, description=$description]"
    }

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }
}
