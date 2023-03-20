package com.doyoung.andoridlab
// 코틀린에서 if~else는 표현식으로도 사용할 수 있음
// 표현식이란 결괏값을 반환하는 계산식을 말함

fun main(){
    var data = 10
    val result = if (data > 0) {
        println("data > 0")
        true // 참일 때 반환값
    } else{
        println("data <= 0")
        false // 거짓일 때 반환값
    }
    println(result)
}
