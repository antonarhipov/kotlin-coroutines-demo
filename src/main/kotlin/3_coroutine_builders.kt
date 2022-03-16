import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        runWork()
    }
    println("Hello")
}

suspend fun runWork() {
    delay(1000L)
    println("World!")
}