package com.radhikayusuf.lib.movie.utils

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/23/21
 */
expect object MovieDispatcher {
    internal val Main: CoroutineDispatcher

    internal val Background: CoroutineDispatcher
}