package io.daio.kungfood

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.UIKit.UIDevice
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName +
            " " +
            UIDevice.currentDevice.systemVersion
}

internal class NsQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}

actual val ioDispatcher = NsQueueDispatcher(dispatch_get_main_queue()) as CoroutineContext
actual val uiDispatcher: CoroutineContext
    get() = ioDispatcher