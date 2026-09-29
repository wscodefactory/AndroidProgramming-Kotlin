fun performOperation(
    a : Int,
    b : Int,
    operation: (Int, Int) -> Int
): Int {
    return operation(a, b)
}

fun main() {
    val a = 10
    val b = 5

    val addition = performOperation(a, b) { x, y -> x + y }
    val multiplication = performOperation(a, b) { x, y -> x * y }
    val larger = performOperation(a, b) { x, y -> if (x > y) x else y }
    val sumOfSquares = performOperation(a, b) { x, y -> (x * x) + (y * y) }

    println("$a + $b = $addition")
    println("$a * $b = $multiplication")
    println("$a, $b 중 큰 값 = $larger")
    println("$a^2 + $b^2 = $sumOfSquares")
}