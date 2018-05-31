package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others

import java.io.Serializable

class Odata(metadata: String) : Serializable {

    var metadata: String? = metadata

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

}
