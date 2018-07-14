package tech.ascendio.mvvmstarter.utilities

import android.os.Handler
import android.os.Looper

import java.util.concurrent.Executor
import java.util.concurrent.Executors

val IO_EXECUTOR = Executors.newSingleThreadExecutor()
val NETWORK_EXECUTOR = Executors.newFixedThreadPool(3)
val MAIN_EXECUTOR = MainThreadExecutor()

/**
 * Utility method to run blocks on a dedicated background thread, used for io/database work.
 */
fun runOnIoThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}

/**
 * Utility method to run blocks on a dedicated background thread, used for network requests.
 */
fun runOnNetworkThread(f: () -> Unit) {
    NETWORK_EXECUTOR.execute(f)
}

/**
 * Utility method to run blocks on the main thread.
 */
fun runOnMainThread(f: () -> Unit) {
    MAIN_EXECUTOR.execute(f)
}

class MainThreadExecutor : Executor {
    private val mainThreadHandler = Handler(Looper.getMainLooper())
    override fun execute(command: Runnable) {
        mainThreadHandler.post(command)
    }
}
