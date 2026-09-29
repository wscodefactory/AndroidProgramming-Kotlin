// 전달받은 상품 하나를 장바구니에 추가
fun addItem(cart : MutableList<String>, item : String) {
    cart.add(item)
}

// 상품 금액에 할인율 적용 후 배송비를 더함
fun calculateFinalAmount(
    totalPrice : Int,
    discountRate : Double = 0.0,
    shippingFee : Int = 3000
) : Int {
    var actualShippingFee = shippingFee

    // 무료배송 여부는 할인 전 상품 총액을 기준으로 판단
    if (totalPrice >= 100000) {
        actualShippingFee = 0
    }

    // 할인 적용 금액의 소수 부분을 제거하여 정수로 변환
    val discountedPrice = (totalPrice * (1.0 - discountRate)).toInt()
        return discountedPrice + actualShippingFee
}

// 장바구니에서 기준 가격 이상인 상품만 새 리스트에 추가
fun getExpensiveItems(
    cart : List<String>,
    catalog : Map<String, Int>,
    minPrice : Int
) : List<String> {

    val expensiveItems = mutableListOf<String>()

    // 람다나 고차함수 없이 for 루프와 if 조건문으로 직접 검사사
    for (item in cart) {
        val price = catalog[item]

        // 카탈로그에 있는 상품 중 기준 가격을 만족하는 상품을 선택
        if (price != null && price >= minPrice) {
            expensiveItems.add(item)
        }
    }
    return expensiveItems
}

fun main() {
    // 상품명을 key로 가격을 value로 저장
    val catalog : Map<String, Int> = mapOf(
        "노트북"  to 1200000,
        "키보드" to 85000,
    )
    val cart : MutableList<String> = mutableListOf()

    addItem(cart, "노트북")
    addItem(cart, "키보드")

    var totalPrice = 0
    // 할인율을 10%로 설정
    val discountRate = 0.10

    println("=== 장바구니 결제 내역===")

    // 장바구니는 카탈로그에 등록한 상품만 담을 수 있게함
    for (item in cart) {
        val price = catalog.getValue(item)
        totalPrice += price
        println("- ${item} : ${String.format("%,d", price)} 원")
    }

    // shippingFee를 생략하면 기본값 3000원이 적용
    val finalAmount = calculateFinalAmount(totalPrice, discountRate)
    val expensiveItem = getExpensiveItems(cart, catalog, 50000)

    println("-------------------------------")
    println("할인율 : ${String.format("%.1f", discountRate * 100)}% 적용")

    if(totalPrice >= 100000) {
        println("배송비 : 0원 (10만원 이상 구매 무료배송)")
    } else {
        println("배송비 : 3000원")
    }

    println ("최종 결제 금액 : ${String.format("%,d", finalAmount)} 원")
    println("[5만원 이상 상품 목록] : $expensiveItem")
}