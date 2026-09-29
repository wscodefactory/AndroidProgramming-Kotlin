import java.text.NumberFormat
import java.util.Locale
data class Order(
    val id: Int,
    val name: String,
    val price: Int,
    val category: String
)

fun filterOrders(
    orders: List<Order>,
    predicate: (Order) -> Boolean
): List<Order> {
    val filteredOrders = mutableListOf<Order>()

    for (order in orders) {
        if (predicate(order)) {
            filteredOrders.add(order)
        }
    }

    return filteredOrders
}

fun processPrices(
    orders: List<Order>,
    transformer: (Int) -> Int
): List<Int> {
    val transformedPrices = mutableListOf<Int>()

    for (order in orders) {
        transformedPrices.add(transformer(order.price))
    }

    return transformedPrices
}

fun main() {
    val orders = listOf(
        Order(1, "노트북", 1_200_000, "전자제품"),
        Order(2, "마우스", 35_000, "전자제품"),
        Order(3, "운동화", 89_000, "패션"),
        Order(4, "모니터", 250_000, "전자제품")
    )

    val filteredOrders = filterOrders(orders) {
        it.category == "전자제품" && it.price >= 50_000
    }

    val discountedPrices = processPrices(filteredOrders) {
        (it * 0.9).toInt()
    }

    println("=== 1. 조건에 맞는 주문 필터링 전자제품( & 5 만원 이상) ===")
    filteredOrders.forEach { order ->
        // 출력 예시처럼 속성 이름도 함께 보여 줍니다.
        println(
            "- Order(id = ${order.id}, name = ${order.name}, " +
                    "price = ${order.price}, category = ${order.category})"
        )
    }

    println()
    println("=== 2. 필터링된 주문에 10% 할인 적용 후 가격 목록 ===")

    filteredOrders.zip(discountedPrices).forEach { (order, discountedPrice) ->
        val formattedPrice = NumberFormat
            .getNumberInstance(Locale.KOREA)
            .format(discountedPrice)
        println("- ${order.name} 할인 가격: $formattedPrice 원")
    }
}