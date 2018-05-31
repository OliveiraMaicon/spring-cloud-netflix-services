package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.offer

class Offers {

    var strings: List<String>? = null

    constructor() {

    }

    constructor(strings: List<String>) {
        this.strings = strings
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (strings == null) 0 else strings!!.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj)
            return true
        if (obj == null)
            return false
        if (javaClass != obj.javaClass)
            return false
        val other = obj as Offers?
        if (strings == null) {
            if (other!!.strings != null)
                return false
        } else if (strings != other!!.strings)
            return false
        return true
    }

    override fun toString(): String {
        return "Offers [strings=$strings]"
    }
}
