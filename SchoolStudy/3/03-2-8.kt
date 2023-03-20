package com.doyoung.andoridlab
// when 문에서는 조건을 데이터 타입, 범위 등으로 다양하게 명시할 수 있음
// is는 타입을 확인하는 연산자이며 in은 범위 지정 연산자

fun main() {
    var data: Any = 10
    when (data) {
        is String -> println("data is String")      // data가 문자열 타입이면
        20, 30 -> println("data is 20 or 30")       // data가 20 또는 30이면
        in 1..10 -> println("data is 1..10")    // datarl 1~10의 값이면
        else -> println("data is not valid")
    }

    var data2 = 10
    var result = when {
        data2 <= 0 -> "data is <= 0"
        data2 > 100 -> "data is > 100"
        else -> "data is valid"
    }
    println(result)
}