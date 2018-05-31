package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.user


import com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.password.PasswordProfile

import java.io.Serializable


class UserAccount : Serializable {

    var id: String? = null
    var displayName: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var usageLocation: String? = null
    var userPrincipalName: String? = null
    var roleId: String? = null
    var passwordProfile: PasswordProfile? = null
        get() {
            if (field == null) {
                this.passwordProfile = PasswordProfile()
            }
            return field
        }

    companion object {
        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }
}
