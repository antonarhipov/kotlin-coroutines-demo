import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

suspend fun main(): Unit = coroutineScope {
    val jobs = List(100_000) {
        launch {
            delay(2000L)
            print("*")
        }
    }
    jobs.forEach { it.join() }
}

//region With threads, it takes ages to complete
fun mainWithThreads() {
    val jobs = List(100_000) {
        thread {
            Thread.sleep(1000L)
            print("*")
        }
    }
    jobs.forEach { it.join() }
}
//endregion