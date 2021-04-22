package com.radhikayusuf.lib.movie.domain.usecases

import com.radhikayusuf.lib.movie.data.repository.MovieRepositoryImpl
import com.radhikayusuf.lib.movie.domain.presenters.MoviePresenters
import com.radhikayusuf.lib.movie.utils.MovieDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/10/21
 */
class MovieUseCase {

    private val movieRepository: MovieRepository = MovieRepositoryImpl()

    private lateinit var presenters: MoviePresenters

    fun initPresenter(presenters: MoviePresenters) {
        this@MovieUseCase.presenters = presenters
    }

    fun fetchMovies() {
        GlobalScope.launch(MovieDispatcher.Background) {
            val result = movieRepository.getMovies()

            if (result.isSuccess) {
                if (!result.data.isNullOrEmpty()) {
                    runOnMain { presenters.showMovies(result.data) }
                } else {
                    runOnMain { presenters.showEmptyResult() }
                }
            } else {
                runOnMain { presenters.showMessage(result.message) }
            }
        }
    }

    private fun runOnMain(block: () -> Unit) {
        GlobalScope.launch(MovieDispatcher.Main) { block.invoke() }
    }
}