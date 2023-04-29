package dev.bcmedeiros.ktor

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import kotlin.test.assertEquals
import kotlin.test.Test

class ApiClientTest {

    @Test
    fun getName() = runBlocking {
        val mockEngine = MockEngine { _ ->
            respond(
                content = ByteReadChannel(""""Sponge Bob""""),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = ApiClient(mockEngine)

        assertEquals("Sponge Bob", apiClient.getName())
    }
}