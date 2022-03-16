fun main() {
    val numbers = fibonacci().take(10).toList()
    println(numbers) // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
}

fun fibonacci(): Sequence<Int> {
    return generateSequence(Pair(0, 1)) {
        Pair(it.second, it.first + it.second)
    }.map { it.first }
}
