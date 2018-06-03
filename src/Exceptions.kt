fun throwException(name: String){
    when (name) {
        "RuntimeException" -> throw RuntimeException("RuntimeException")
        "IllegalArgumentException" -> throw IllegalArgumentException("IllegalArgumentException")
        "IndexOutOfBoundsException" -> throw IndexOutOfBoundsException("IndexOutOfBoundsException")
        else -> println("Not an exception")
    }

}

fun handleException(name : String){
    try {
        throwException(name)
    } catch (e : Exception){
        when (e) {
            is IllegalArgumentException -> println("Handling an IllegalArgumentException")
            is IndexOutOfBoundsException -> println("Handling an IndexOutOfBoundsException")
            is RuntimeException -> println("Handling a Runtime Exception")
        }
    }
}

fun returnFromWhen(name : String): Class<out RuntimeException>? {
    return when(name){
        "RuntimeException" -> RuntimeException::class.java
        "IllegalArgumentException" -> IllegalArgumentException::class.java
        "IndexOutOfBoundsException" -> IndexOutOfBoundsException::class.java
        else -> {
            println("Returning a null value")
            null
        }
    }
}


fun main(args : Array<String>){
    handleException("RuntimeException")
    handleException("IllegalArgumentException")
    handleException("IndexOutOfBoundsException")
    handleException("Bob")

    println()

    println(returnFromWhen("RuntimeException"))
    println(returnFromWhen("IllegalArgumentException"))
    println(returnFromWhen("IndexOutOfBoundsException"))
    println(returnFromWhen("Bob"))
}