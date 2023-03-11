package com.doyoung.andoridlab

lateinit var string:String

val data1: Int by lazy{
    println("in lazy...")
    10
}
fun main(){
    println("Hello World!!")
    val data = 10
    println("value data")
    println("Value $data")
    println("Value ${data+10}")
    println()

    string = "aaa"
    println("value ${data + 10} $string")
    println()

    println("in main....")
    println(data1 + 10)
    println(data1 + 10)
    println()
    someFun2()
}

fun someFun(){
    var data3: Int = 10
    var data4: Int? = null      // null 대입 가능

    data3 = data3 + 10
    data3 = data3.plus(10)      // 객체의 메소드 이용 가능 (메소드 호출 가능)
    // "?"는 널 값이 들어갈 수 있다는 표시
}

fun someFun2(){
    val str1 = "Hello \n World"
    val str2 = """
        Hello
        World
    """
    println("str1 : $str1")
    println("str2 : $str2")
}

fun someFun3_2(){
    fun some(data1: Int, data2: Int = 10): Int{
        return data1 * data2

    }
    println(some(10))
    println(some(10, 20))
}