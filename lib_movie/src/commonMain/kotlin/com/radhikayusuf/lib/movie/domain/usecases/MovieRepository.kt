package com.radhikayusuf.lib.movie.domain.usecases

import com.radhikayusuf.lib.movie.data.model.Result
import com.radhikayusuf.lib.movie.domain.entities.MovieEntity

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/17/21
 */
interface MovieRepository {
    suspend fun getMovies(): Result<List<MovieEntity>>
}