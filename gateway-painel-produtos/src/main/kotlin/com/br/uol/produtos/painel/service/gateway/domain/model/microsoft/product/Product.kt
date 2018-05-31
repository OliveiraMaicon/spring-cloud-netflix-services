package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.product

import java.io.Serializable

class Product : Serializable {

    var id: String? = null
    var name: String? = null
    var unit: String? = null

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

}
