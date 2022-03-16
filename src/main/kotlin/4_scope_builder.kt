import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.future.future
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CompletableFuture

fun main() = runBlocking {
    doWork()
    println("Hello")
}

suspend fun doWork() = coroutineScope {
    launch {
        delay(1000L)
        println("World! - 1")
    }
    launch {
        delay(1000L)
        println("World! - 2")
    }
    println("Done!")
}