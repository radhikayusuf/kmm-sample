package com.radhikayusuf.lib.movie.data.services

import com.radhikayusuf.lib.movie.data.model.Movie
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/10/21
 */
class MovieService {
    companion object {
        private const val URL =
            "https://jobs.github.com/positions"
    }

    private val httpApiClient: HttpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getJobInfo(): List<Movie> {
        return httpApiClient.get("$URL.json?full_time=true&location=uk")
    }

    suspend fun getJobDetail(jobId: String): Movie {
        return httpApiClient.get("$URL/$jobId.json")
    }
}
