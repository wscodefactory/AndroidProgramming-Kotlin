open class View(val id: String, var isVisible: Boolean) {
    fun show() {
        isVisible = true
    }

    fun hide() {
        isVisible = false
    }
}
class TextView(
    id : String,
    var text: String
): View(id, true)

class Toggle(id: String) : View(id, true){
    var isOn : Boolean = false
    fun click(){
        isOn = !isOn
    }
}

fun main() {
    val view = View(id = "v1", isVisible = false)
    println(view.id)
    println(view.isVisible)

    val textView = TextView(
        id = "tv1",
        text = "Hello World!",
    )

    println(textView.id)
    println(textView.text)
    println(textView.isVisible)

    textView.text = "Welcome to Kotlin!"
    println(textView.text)

    textView.hide()
    println(textView.isVisible)

    val toggle = Toggle(id = "toggle1",)
    println(toggle.id)
    println(toggle.isOn)
    toggle.click()
    println(toggle.isOn)

    println(toggle.isVisible)
    toggle.hide()
    println(toggle.isVisible)
    toggle.show()
    println(toggle.isVisible)
}