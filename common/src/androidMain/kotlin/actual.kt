package io.daio.kungfood

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual fun platformName(): String {
    return "Android"
}


actual val ioDispatcher = Dispatchers.IO as CoroutineContext
actual val uiDispatcher = Dispatchers.Main as CoroutineContext