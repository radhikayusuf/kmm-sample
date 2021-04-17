package com.radhikayusuf.lib.movie

import com.radhikayusuf.lib.movie.utils.Greeting
import kotlin.test.Test
import kotlin.test.assertTrue

class GreetingTest {

    @Test
    fun testExample() {
        assertTrue(Greeting().greeting().contains("iOS"), "Check iOS is mentioned")
    }
}