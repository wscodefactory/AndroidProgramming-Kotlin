interface Listener {
    fun onTest1()
    fun onTest2(test: String) : Unit
    fun onError(error: String) : Unit
    fun onSuccess(value1: String, value2: String)
}

fun makeNetworkCallTraditionalWay(name: String, listener : Listener) {
    // Some code to make network call and fetch data
    val myData1 = "some data 1 from network...."
    val myData2 = "some data 2 from network...."
    val myError = "some error from network...."
    if(name.isEmpty()) {
        listener.onTest1()
    } else if (name.length < 5) {
        listener.onTest2("test")
    } else if (name.length < 7) {
        listener.onSuccess(myData1,myData2)
    } else {
        listener.onError(myError)
    }
}

fun listenerWay(name : String) {
    makeNetworkCallTraditionalWay(name, object : Listener {
        override fun onTest1() {
            println("test 1 call...")
        }
        override fun onTest2(test: String) {
            println("test 2 call...")
        }
        override fun onSuccess(value1: String, value2: String) {
            println("onSuccess call...")
        }
        override fun onError(error: String) {
            println("onError call...")
        }
    })
}

fun main()
{
    listenerWay("")
    listenerWay("Garv")
    listenerWay("Gaurav")
    listenerWay("Gaurav Tyagi")
}