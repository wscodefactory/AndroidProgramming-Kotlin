val lambda3 : (String) -> Unit = { name: String -> println("Hello $name")}
// case 1 : full syntactic form
val lambda4 = { name : String -> println("Hello $name") }
// case 2 : declare type of parameter on right side

val lambda5 : (String) -> Unit = { name -> println("Hello $name") }
// case 3: declare type of parameter on left side
val lambda6 : (String) -> Unit = { println("Hello $it")}
// case 4: Uses of it if we have single parameter

fun main() {
    lambda3("Kotlin")
    lambda4("Kotlin")
    lambda5("Kotlin")
    lambda6("Kotlin")
}