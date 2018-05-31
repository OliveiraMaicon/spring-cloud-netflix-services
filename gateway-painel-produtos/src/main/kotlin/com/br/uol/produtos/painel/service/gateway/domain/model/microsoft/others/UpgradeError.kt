package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others

import java.io.Serializable

class UpgradeError : Serializable {

    var code: Int? = null
    var description: String? = null
    var attributes: Attributes? = null

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

}
