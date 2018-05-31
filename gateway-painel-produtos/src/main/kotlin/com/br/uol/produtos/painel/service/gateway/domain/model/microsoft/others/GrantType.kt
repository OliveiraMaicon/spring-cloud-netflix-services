package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others

import java.io.Serializable

class GrantType : Serializable {
    var grant_type = "client_credentials"

    companion object {

        private const val serialVersionUID = 1L
    }
}
