package com.radhikayusuf.lib.movie.domain.entities

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/17/21
 */
data class MovieEntity(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String
)