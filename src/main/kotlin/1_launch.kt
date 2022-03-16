import kotlinx.coroutines.*
import java.util.concurrent.Executors

//val threadPool = Executors.newFixedThreadPool(2)
//val dispatcher = threadPool.asCoroutineDispatcher()

fun process(n: Int): Int {
    println("process: ${Thread.currentThread()}")
    return n
}

fun main(): Unit = runBlocking {
    println(Thread.currentThread())

    launch(Dispatchers.IO) {
        println(process(2))
    }
}