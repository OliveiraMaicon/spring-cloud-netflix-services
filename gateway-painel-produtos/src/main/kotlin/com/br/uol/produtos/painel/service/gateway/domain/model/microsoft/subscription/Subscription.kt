package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.subscription


import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others.Attributes

import java.io.Serializable

class Subscription : Serializable {

    var totalCount: Int? = null
    var items: List<SubscriptionItem>? = null
    var attributes: Attributes? = null

    init {
        this.totalCount = 0
    }

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

}
