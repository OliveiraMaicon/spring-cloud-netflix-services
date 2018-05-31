package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others

import java.io.Serializable

class Attributes : Serializable {

    var etag: String? = null
    var objectType: String? = null

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

}
