package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.link

import java.io.Serializable

class Link : Serializable {

    var offer: LinkItem? = null
    var entitlement: LinkItem? = null
    var self: LinkItem? = null

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

}
