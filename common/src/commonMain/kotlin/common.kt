package io.daio.kungfood

import kotlin.coroutines.CoroutineContext

expect fun platformName(): String

expect val ioDispatcher: CoroutineContext

expect val uiDispatcher: CoroutineContext