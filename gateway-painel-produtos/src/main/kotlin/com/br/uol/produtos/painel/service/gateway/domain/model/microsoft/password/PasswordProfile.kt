package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.password

import java.io.Serializable

class PasswordProfile : Serializable {

    var password: String? = null
    var forceChangePassword: Boolean? = null


    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

}
