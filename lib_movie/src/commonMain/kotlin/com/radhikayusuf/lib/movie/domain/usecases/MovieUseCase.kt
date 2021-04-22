package com.radhikayusuf.lib.movie.domain.usecases

import com.radhikayusuf.lib.movie.data.repository.MovieRepositoryImpl
import com.radhikayusuf.lib.movie.domain.presenters.MoviePresenters
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/10/21
 */
class MovieUseCase() {

    private val movieRepository: MovieRepository = MovieRepositoryImpl()

    private lateinit var presenters: MoviePresenters

    fun initPresenter(presenters: MoviePresenters) {
        this@MovieUseCase.presenters = presenters
    }

    suspend fun fetchMovies() {
        val result = movieRepository.getMovies()
        if (result.isNotEmpty()) {
            presenters.showMovies(result)
        } else {
            presenters.showEmptyResult()
        }
    }
}