package com.radhikayusuf.lib.movie.domain.presenters

import com.radhikayusuf.lib.movie.domain.entities.MovieEntity

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/17/21
 */
interface MoviePresenters {

    fun showMovies(list: List<MovieEntity>)

    fun showEmptyResult()
}