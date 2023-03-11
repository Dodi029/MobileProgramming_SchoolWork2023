package com.doyoung.andoridlab
// 함수의 매개변수에는 기본값 선언 가능

fun main(){
    fun some(data1: Int, data2: Int = 10): Int{
        return data1 * data2

    }
    println(some(10))
    println(some(10, 20))

    // 매개변수명을 지정하여 호출하는 것을 명명된 매개변수라고 하며, 이렇게 하면 함수 선언문의 매개변수 순서에 맞춰 호출하지 않아도 됨
    some(data2 = 20, data1 = 10)
}