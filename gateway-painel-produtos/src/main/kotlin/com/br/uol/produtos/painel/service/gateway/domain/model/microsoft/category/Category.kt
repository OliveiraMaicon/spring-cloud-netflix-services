package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.category

import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others.Attributes

import java.io.Serializable

class Category : Serializable {

    var id: String? = null
    var name: String? = null
    var rank: Int? = null
    var locale: String? = null
    var country: String? = null
    var attributes: Attributes? = null

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

}
