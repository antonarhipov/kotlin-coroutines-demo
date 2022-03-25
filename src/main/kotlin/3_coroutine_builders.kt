import kotlinx.coroutines.*

fun main() = runBlocking {
    val job: Job = launch {
        runWork()
    }

    val async: Deferred<Unit> = async {
        runWork()
    }
    println("Hello")
}

suspend fun runWork() {
    delay(1000L)
    println("World!")
}