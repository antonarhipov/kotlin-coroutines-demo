import kotlinx.coroutines.*
import java.util.concurrent.Executors

//val threadPool = Executors.newFixedThreadPool(2)
//val dispatcher = threadPool.asCoroutineDispatcher()

//suspend fun process(n: Int): Int = withContext(dispatcher) {
//    println("process: ${Thread.currentThread()}")
//    return@withContext n
//}

suspend fun process(n: Int) : Int {
    println("process: ${Thread.currentThread()}")
    return n
}

fun main(): Unit = runBlocking {
    println(Thread.currentThread())

    launch {
        println(process(2))
    }
}