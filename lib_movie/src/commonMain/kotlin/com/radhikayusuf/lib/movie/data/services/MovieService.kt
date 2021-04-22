package com.radhikayusuf.lib.movie.data.services

import com.radhikayusuf.lib.movie.data.model.BaseResponse
import com.radhikayusuf.lib.movie.data.model.MovieResponseModel
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
            "https://api.themoviedb.org/3/"
    }

    private val httpApiClient: HttpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getMovies(): BaseResponse<List<MovieResponseModel>> {
        return try {
            httpApiClient.get("${URL}movie/popular?api_key=xxx")
        } catch (e: Exception) {
            return BaseResponse(emptyList(), -1, e.message.orEmpty())
        }
    }
}
