package com.radhikayusuf.lib.movie.data.repository

import com.radhikayusuf.lib.movie.data.services.MovieService
import com.radhikayusuf.lib.movie.domain.entities.MovieEntity
import com.radhikayusuf.lib.movie.domain.usecases.MovieRepository

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/17/21
 */

class MovieRepositoryImpl : MovieRepository {

    private val service: MovieService = MovieService()

    override suspend fun getMovies(): List<MovieEntity> {
        val result = service.getMovies()
        return result.data
            .orEmpty()
            .map {
                MovieEntity(
                    it.id ?: 0,
                    it.title.orEmpty(),
                    it.overview.orEmpty(),
                    "https://image.tmdb.org/t/p/w185${it.posterPath.orEmpty()}"
                )
            }
    }
}