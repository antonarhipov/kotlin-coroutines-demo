import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = async {
        runWorkInt()
    }
    println("Hello")
    println("Answer: ${job.await()}")
}

suspend fun runWorkInt(): Int {
    delay(1000L)
    println("World!")
    return 42
}