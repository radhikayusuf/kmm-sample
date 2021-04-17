package com.radhikayusuf.lib.movie.utils

import com.radhikayusuf.lib.movie.data.model.Movie

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    fun createListOfNames() =
        listOf("Radhika", "Yusuf", "Alifiansyah")

    fun createListOfMovies() =
        listOf(
            Movie(0, "Avengers", "xxx"),
            Movie(1, "Falcon and the winter soldier", "xxx"),
            Movie(2, "IT", "xxx")
        )
}