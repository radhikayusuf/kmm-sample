package com.radhikayusuf.lib.movie

import com.radhikayusuf.lib.movie.Calculator
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun testSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }

}