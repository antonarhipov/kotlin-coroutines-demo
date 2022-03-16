import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

val threadPool = Executors.newFixedThreadPool(2)
val dispatcher = threadPool.asCoroutineDispatcher()

fun process(n: Int): Int {
    println("process: ${Thread.currentThread()}")
    return n
}

fun main(): Unit = runBlocking {
    println(Thread.currentThread())

    launch(Dispatchers.IO) {
        println(process(2))
    }

    launch(dispatcher) {
        println(process(5))
    }

    threadPool.shutdown()
}