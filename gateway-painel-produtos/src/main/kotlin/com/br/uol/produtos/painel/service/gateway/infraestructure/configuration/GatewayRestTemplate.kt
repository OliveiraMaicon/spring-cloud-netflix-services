package com.br.uol.produtos.painel.service.gateway.infraestructure.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.*
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.client.RestTemplate
import java.util.ArrayList

@Component
class GatewayRestTemplate {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    private val mapper = ObjectMapper()

    @Autowired
    @Qualifier("poolingHttpClientRequestFactory")
    private lateinit var clientHttpRequestFactory: ClientHttpRequestFactory

    private var restTemplate = RestTemplate()

    private var url: String? = null

    private lateinit var headers: HttpHeaders

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getHeaders(): HttpHeaders? {
        return headers
    }

    fun setHeaders(headers: HttpHeaders): GatewayRestTemplate {
        this.headers = headers
        return this
    }

    fun setWeakHeaders(): GatewayRestTemplate {

        headers = HttpHeaders()
        val accept = ArrayList<MediaType>()
        accept.add(MediaType.APPLICATION_JSON)

        headers.accept = accept
        headers.contentType = MediaType.APPLICATION_JSON
        return this
    }

    fun addHeaders(key: String, value: String): GatewayRestTemplate {
        this.headers.add(key, value)
        return this
    }

    fun addHeaders(headers: HttpHeaders): GatewayRestTemplate {
        this.headers.putAll(headers)
        return this
    }


    @Throws(HttpStatusCodeException::class, Exception::class)
    operator fun <T> get(responseType: Class<T>): ResponseEntity<T> {
        return get(responseType, "")
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    operator fun <T, Q> get(responseType: Class<T>, body: Q): ResponseEntity<T> {
        return sendRequest(responseType, body, HttpMethod.GET)
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    fun <T> post(responseType: Class<T>): ResponseEntity<T> {
        return post(responseType, "")
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    fun <T, Q> post(responseType: Class<T>, body: Q): ResponseEntity<T> {
        return sendRequest(responseType, body, HttpMethod.POST)
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    fun <T> put(responseType: Class<T>): ResponseEntity<T> {
        return put(responseType, "")
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    fun <T, Q> put(responseType: Class<T>, body: Q): ResponseEntity<T> {
        return sendRequest(responseType, body, HttpMethod.PUT)
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    fun <T> delete(responseType: Class<T>): ResponseEntity<T> {
        return delete(responseType, "")
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    fun <T, Q> delete(responseType: Class<T>, body: Q): ResponseEntity<T> {
        return sendRequest(responseType, body, HttpMethod.DELETE)
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    fun <T> patch(responseType: Class<T>): ResponseEntity<T> {
        return patch(responseType, "")
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    fun <T, Q> patch(responseType: Class<T>, body: Q): ResponseEntity<T> {
        restTemplate = RestTemplate(clientHttpRequestFactory)
        return sendRequest(responseType, body, HttpMethod.PATCH)
    }

    @Throws(HttpStatusCodeException::class, Exception::class)
    private fun <Q, T> sendRequest(responseType: Class<T>, body: Q, httpMethod: HttpMethod): ResponseEntity<T> {
        val httpEntity = HttpEntity(body, headers)
        try {
            logger.info("Requisitando o servico: " + httpMethod.toString() + " " + url)
            logger.debug("Header: " + mapper.writeValueAsString(headers))
            logger.debug("Body: " + mapper.writeValueAsString(body))
            val response = restTemplate.exchange(url, httpMethod, httpEntity, responseType) as ResponseEntity<T>
            logger.info("Requisição concluida com sucesso!")
            logger.info("Response: " + mapper.writeValueAsString(response))
            return response
        } catch (e: HttpClientErrorException) {
            logger.error("Ocorreu um erro na requisicao do servico. Motivo: {} - HTTP Status: {}", e.responseBodyAsString, e.rawStatusCode)
            throw e
        } catch (e: HttpServerErrorException) {
            logger.error("Ocorreu um erro na requisicao do servico. Motivo: {} - HTTP Status: {}", e.responseBodyAsString, e.rawStatusCode)
            throw e
        } catch (e: Exception) {
            logger.error("Ocorreu um erro na requisicao do servico. Motivo: {} - {}", e, e.message)
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }
}