package com.doyoung.andoridlab
// 조건문 when

fun main() {
    var data = 10
    when(data) {
        10 -> println("data is 10")
        20 -> println("data is 20")
        else -> {
            println("data is not valid data")
        }
    } // break 문이 필요가 없음

    var data2 = "hello"
    when (data2) {
        "hello" -> println("data2 is hello")
        "world" -> println("data2 is world")
        else -> {
            println("data2 is not valid data")
        }
    }
}