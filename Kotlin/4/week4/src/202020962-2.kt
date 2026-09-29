class Product(val name: String, val price: Double, quantity: Int){
    var quantity: Int = quantity.coerceAtLeast(0)
        set (value){
            field = value.coerceAtLeast(0)
        }
    fun calculateTotalValue(): Double {
        return price * quantity
    }
    fun restock(amount: Int){
        if (amount > 0){
            quantity += amount
        }
    }
}

fun main() {
    val laptop = Product("Laptop", 999.99, 5)
    println(laptop.name)
    println(laptop.quantity)
    println(laptop.calculateTotalValue())

    laptop.restock(3)
    println(laptop.quantity)
    println(laptop.calculateTotalValue())

    laptop.quantity = -2
    println(laptop.quantity)
    println(laptop.calculateTotalValue())

    laptop.quantity = 10
    println(laptop.quantity)
    println(laptop.calculateTotalValue())
}

