fun main() {

    val sequence = sequence {
        for (i in 1..5) {
            println("Yielding $i")
            yield(i)
        }

        println("done")
    }

    for (value in sequence) {
        println("Yielded value is $value")
    }
}

