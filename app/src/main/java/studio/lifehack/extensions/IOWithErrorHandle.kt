package studio.lifehack.extensions

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

fun Dispatchers.IOWithErrorHandling(handler: (Throwable) -> Unit): CoroutineContext {
    return SupervisorJob() + IO + CoroutineExceptionHandler { _, throwable ->
        handler.invoke(throwable)
    }
}