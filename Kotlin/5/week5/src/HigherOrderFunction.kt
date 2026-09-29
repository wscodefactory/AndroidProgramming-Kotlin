fun subtract(x: Int, y: Int): Int {
    return x - y
}

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(x, y)
    return result
}

fun main() {
    val sum = calculate(5, 3) { a, b -> a + b }
    val product = calculate(5, 3) { a, b -> a * b }

    println("Sum = $sum")
    println("Product = $product")

    val sub = calculate(10, 5, ::subtract)
    println("Subtraction = $sub")
}