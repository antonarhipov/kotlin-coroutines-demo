suspend fun main() {
    val res = generate()
    process(res)
}

suspend fun generate(): Any {
    return "Hello"
}

suspend fun process(o: Any) {
    println(o)
}


