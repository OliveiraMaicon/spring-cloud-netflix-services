package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.subscription

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.link.Link
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.offer.TargetOffer
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others.Attributes
import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others.UpgradeError
import com.fasterxml.jackson.annotation.JsonProperty

import java.io.Serializable

class SubscriptionItem : Serializable {

    var id: String? = null
    var offerName: String? = null
    var friendlyName: String? = null
    var quantity: Int? = null
    var unitType: String? = null
    var creationDate: String? = null
    var status: String? = null
    var autoRenewEnabled: Boolean? = null
    var billingType: String? = null
    var contractType: String? = null
    var links: Link? = null
    var offer_uri: String? = null
    @get:JsonProperty("order_id")
    @set:JsonProperty("order_id")
    var order_id: String? = null
    var targetOffer: TargetOffer? = null
    var upgradeType: String? = null
    var isEligible: Boolean? = null
    var effectiveStartDate: String? = null
    var commitmentEndDate: String? = null
    var upgradeErrors: List<UpgradeError>? = null
    var attributes: Attributes? = null

    fun getOrderId(): String? {
        return order_id
    }

    fun setOrderId(orderId: String) {
        this.order_id = orderId
    }

    override fun toString(): String {
        return "SubscriptionItem [id=$id, friendlyName=$friendlyName]"
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (id == null) 0 else id!!.hashCode()
        result = prime * result + if (targetOffer == null) 0 else targetOffer!!.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj)
            return true
        if (obj == null)
            return false
        if (javaClass != obj.javaClass)
            return false
        val other = obj as SubscriptionItem?
        if (id == null) {
            if (other!!.id != null)
                return false
        } else if (id != other!!.id)
            return false
        if (targetOffer == null) {
            if (other.targetOffer != null)
                return false
        } else if (targetOffer != other.targetOffer)
            return false
        return true
    }

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }


}
