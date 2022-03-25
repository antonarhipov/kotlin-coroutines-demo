import kotlinx.coroutines.*

// Read https://elizarov.medium.com/coroutine-context-and-scope-c8b255d59055

fun main() = runBlocking {
    doWork()
    println("Hello")
}

suspend fun doWork() = coroutineScope {
    println("1: ${coroutineContext}")

    val job = launch(Dispatchers.IO) {
        println("2: ${coroutineContext}")
        delay(1000L)
        launch {
            while (true) {
                println("3: ${coroutineContext}")
                delay(1000L)
            }
        }
    }

    delay(3000)
    println("done!")
    job.cancel()

    println("Done!")
}