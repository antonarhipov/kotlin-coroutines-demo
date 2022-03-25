import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

//@OptIn(ExperimentalCoroutinesApi::class)
//fun CoroutineScope.foo(): ReceiveChannel<Int> = produce {
//    for (i in 1..10) {
//        send(i)
//        delay(100)
//    }
//}

fun main() = runBlocking<Unit> {
    val producer = launch(CoroutineName("producer")) {
        for (i in 1..10) {
            channel.send(i)
        }
        done.send(1)
    }

    val consumer = launch(CoroutineName("consumer")) {
        for (msg in channel) {
            println(msg)
        }
    }
    done.receive()
    println("done!")
    producer.cancel()
    consumer.cancel()
}
val channel: Channel<Int> = Channel()
val done: Channel<Int> = Channel()