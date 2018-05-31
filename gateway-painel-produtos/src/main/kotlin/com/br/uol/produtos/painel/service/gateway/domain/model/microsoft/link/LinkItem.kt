package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.link

import java.io.Serializable

class LinkItem : Serializable {



    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

    var href: String? = null
    var uri: String? = null
    var method: String? = null

}
