package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.user

import java.io.Serializable

class UserCredentials(userName: String, password: String) : Serializable {

    var userName: String? = userName
    var password: String? = password


    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }

}
