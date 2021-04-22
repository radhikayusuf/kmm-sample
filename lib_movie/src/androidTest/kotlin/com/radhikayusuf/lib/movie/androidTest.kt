package com.radhikayusuf.lib.movie

import com.radhikayusuf.lib.movie.utils.Greeting
import org.junit.Assert.assertTrue
import org.junit.Test

class GreetingTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", Greeting().greeting().contains("Android"))
    }
}