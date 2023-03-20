package com.doyoung.andoridlab
// 고차 함수 : 함수를 매개변수로 전달받거나 반환하는 함수를 의미

fun hofFun(arg : (Int) -> Boolean) : () -> String {
    val result = if(arg(10)) {
        "valid"
    } else {
        "invalid"
    }
    return {"hofFun result : $result"}
}
fun main() {
    val result = hofFun({no -> no > 0})
    println(result())
}