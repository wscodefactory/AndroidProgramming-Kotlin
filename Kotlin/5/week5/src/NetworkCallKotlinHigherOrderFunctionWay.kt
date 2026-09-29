fun makeNetworkCallKotlinHigherOrderFunctionWay(name: String,
                                                onTest1 : () -> Unit,
                                                onTest2 : (test: String) -> Unit,
                                                onSuccess: (value1: String, value2: String) -> Unit,
                                                onError: (error: String) -> Unit
) {
    // Some code to make network call and fetch data
    val myData1 = "some data 1 from network...."
    val myData2 = "some data 2 from network...."
    val myError = "some error from network...."
    if(name.isEmpty()) {
        onTest1()
    } else if (name.length < 5) {
        onTest2("test_2")
    } else if (name.length < 7) {
        onSuccess(myData1,myData2)
    } else {
        onError(myError)
    }
}

fun lambdaWay(name : String) {
    makeNetworkCallKotlinHigherOrderFunctionWay(name, onTest1 = {
        println("test 1 call...")
    }, { //use 'it'
        println("test 2 call... $it")
    }, onSuccess = { value1, value2 ->
        println("onSuccess call...")
    }, onError = { error ->
        println("onError call...")
    })
}
fun main() {
    lambdaWay("")
    lambdaWay("Grav")
    lambdaWay("Gaurav")
    lambdaWay("Gaurav Tyagi")
}