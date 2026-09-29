fun calculateSumOfSquares(n: Int): Int {
    var sum = 0
    for (i in 1..n) {
        sum += i * i
    }
    return sum
}

fun calculateSumOfEven(n: Int): Int {
    var sum = 0
    for (i in 1..n) {
        if (i % 2 == 0) {
            sum += i
        }
    }
    return sum
}
fun countDownByStep(start: Int, end: Int, step: Int): String {
    return (start downTo end step step).joinToString(", ")
}

fun main() {
    println(calculateSumOfSquares(0))
    println(calculateSumOfSquares(1))
    println(calculateSumOfSquares(2))
    println(calculateSumOfSquares(3))
    println(calculateSumOfSquares(4))

    println(calculateSumOfEven(0))
    println(calculateSumOfEven(1))
    println(calculateSumOfEven(2))
    println(calculateSumOfEven(3))
    println(calculateSumOfEven(5))
    println(calculateSumOfEven(10))
    println(calculateSumOfEven(12))
    println(calculateSumOfEven(20))

    println(countDownByStep(1, 1, 1))
    println(countDownByStep(5, 1, 2))
    println(countDownByStep(10, 1, 3))
    println(countDownByStep(15, 5, 5))
    println(countDownByStep(20, 2, 3))
    println(countDownByStep(10, 4, 3))
    println(countDownByStep(-1, -1, 1))
    println(countDownByStep(-5, -9, 2))
}