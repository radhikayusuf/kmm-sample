package com.radhikayusuf.lib.movie.utils

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    fun createListOfNames() =
        listOf("Radhika", "Yusuf", "Alifiansyah")
}