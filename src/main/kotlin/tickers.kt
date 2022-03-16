import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


suspend fun getStockPrice(ticker: String) =
//    java.net.URL("http://localhost:8080/$ticker").readText()
    java.net.URL("https://api.ipify.org").readText()

suspend fun getCallerIp() =
    java.net.URL("https://api.ipify.org").readText()

suspend fun process(ticker: String) {
    println("Processing in thread: ${Thread.currentThread()}")
    try {
        println("Getting ticker $ticker")
        val price = getStockPrice(ticker)
        try {
            println("Getting IP ($ticker)")
            val ip = getCallerIp()
            println("Price for $ticker is $price. Caller IP is $ip")
        } catch (e: Exception) {
            println("Error getting the IP")
        }
    } catch (e: Exception) {
        println("Error getting price for $ticker")
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun main(): Unit = runBlocking {
    val tickers = listOf(
        "GOOG",
        "MSFT",
        "APPL",
        "AMZN",
    )
    println("Thread: ${Thread.currentThread()}")

    val dispatcher = Dispatchers.IO.limitedParallelism(2)

    for (ticker in tickers) {
        launch(dispatcher) {
            process(ticker)
        }
    }
}