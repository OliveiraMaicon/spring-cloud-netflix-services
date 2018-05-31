package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.user

import java.io.Serializable

class UsersList : Serializable {

    var totalCount: Int? = null

    var items: List<UserAccount>? = null

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (items == null) 0 else items!!.hashCode()
        result = prime * result + if (totalCount == null) 0 else totalCount!!.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (javaClass != other.javaClass)
            return false
        val other = other as UsersList?
        if (items == null) {
            if (other!!.items != null)
                return false
        } else if (items != other!!.items)
            return false
        if (totalCount == null) {
            if (other.totalCount != null)
                return false
        } else if (totalCount != other.totalCount)
            return false
        return true
    }

    override fun toString(): String {
        return "UsersList [items=$items]"
    }

    companion object {

        /**
         *
         */
        private const val serialVersionUID = 1211891577805563952L
    }
}
