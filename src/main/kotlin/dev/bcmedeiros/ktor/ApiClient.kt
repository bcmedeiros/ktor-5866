package dev.bcmedeiros.ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class ApiClient(
    engine: HttpClientEngine,
) {
    private val httpClient = HttpClient(engine) {
        install(ContentNegotiation) {
            json()
        }
    }

    @Suppress("UnnecessaryVariable")
    suspend fun getName(): String {
        val response = httpClient.get("/name")
        val body: String = response.body<String>()
        return body
    }
}