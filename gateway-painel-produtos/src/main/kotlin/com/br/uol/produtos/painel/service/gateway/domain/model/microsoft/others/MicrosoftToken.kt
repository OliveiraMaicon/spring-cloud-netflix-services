package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.others

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer

import java.io.Serializable
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.TimeZone

class MicrosoftToken : Serializable {

    @JsonProperty("access_token")
    var accessToken: String? = null

    @JsonProperty("token_type")
    private var tokenType: String? = null

    @JsonProperty("expires_in")
    var expiresIn: Int? = null

    @JsonProperty("expires_on")
    var expiresOn: Long? = null

    @JsonProperty("not_before")
    var notBefore: Long? = null

    @JsonProperty("resource")
    var resource: String? = null

    @JsonProperty("localDateTimeToExpiresOn")
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    private val localDateTimeToExpiresOn: LocalDateTime? = null

    @JsonProperty("localTimeToExpiresIn")
    @JsonSerialize(using = LocalTimeSerializer::class)
    @JsonDeserialize(using = LocalTimeDeserializer::class)
    private val localTimeToExpiresIn: LocalTime? = null

    @JsonProperty("valid")
    private val valid: Boolean = false

    val isValid: Boolean
        get() = if (expiresOn == null) false else LocalDateTime.now().isBefore(getLocalDateTimeToExpiresOn()!!)

    /**
     * Se o token possuir tempo para expirar, (representado em segundos na variável
     * expiresOn), retorna a data e hora deste, senão retorna null.
     * @return LocalDateTime contendo tempo de vida útil ou a data e hora atual.
     */
    fun getLocalDateTimeToExpiresOn(): LocalDateTime? {
        return if (expiresOn == null) null else LocalDateTime.ofInstant(Instant.ofEpochSecond(expiresOn!!), TimeZone.getDefault().toZoneId())

    }

    /**
     * Se o token possuir vida útil, (representado em segundos na variável expiresIn),
     * retorna a vida útil em horas e, se o token não possuir vida útil, retorna null.
     * @return LocalTime contendo a duração em horas do token.
     */
    fun getLocalTimeToExpiresIn(): LocalTime? {
        return if (expiresIn == null) null else LocalTime.ofSecondOfDay(expiresIn!!.toLong())

    }

    fun setTokenType(tokenType: String) {
        this.tokenType = tokenType
    }

    override fun toString(): String {
        return ("MicrosoftToken [accessToken=" + accessToken + ", tokenType="
                + tokenType + ", expiresIn=" + expiresIn + ", expiresOn="
                + expiresOn + ", notBefore=" + notBefore + ", resource="
                + resource + ", localDateTimeToExpiresOn="
                + localDateTimeToExpiresOn + ", localTimeToExpiresIn="
                + localTimeToExpiresIn + "]")
    }

    companion object {

        /**
         * Serial default
         */
        private const val serialVersionUID = 1L
    }
}
