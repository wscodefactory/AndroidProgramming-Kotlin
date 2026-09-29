fun main() {
    val words = listOf("apple", "banana", "kiwi", "orange", "tea", "coffee")

    val result = words
        .filter { it.length >= 4 }
        .map { it.uppercase() }

    println("=== 필터링 및 변환 결과 ===")
    result.forEach {println(it)}
}