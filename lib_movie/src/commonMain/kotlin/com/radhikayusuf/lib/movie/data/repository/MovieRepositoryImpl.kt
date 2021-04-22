package com.radhikayusuf.lib.movie.data.repository

import com.radhikayusuf.lib.movie.data.model.Result
import com.radhikayusuf.lib.movie.data.services.MovieService
import com.radhikayusuf.lib.movie.domain.entities.MovieEntity
import com.radhikayusuf.lib.movie.domain.usecases.MovieRepository

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/17/21
 */

class MovieRepositoryImpl : MovieRepository {

    private val service: MovieService = MovieService()

    override suspend fun getMovies(): Result<List<MovieEntity>> {
        val data = service.getMovies()
        return if (data.status == -1) {
            Result(false, null, data.message.orEmpty())
        } else {
            val result = data.data
                .orEmpty()
                .map {
                    MovieEntity(
                        it.id ?: 0,
                        it.title.orEmpty(),
                        it.overview.orEmpty(),
                        "https://image.tmdb.org/t/p/w185${it.posterPath.orEmpty()}"
                    )
                }
            Result(true, result, data.message.orEmpty())
        }
    }
}