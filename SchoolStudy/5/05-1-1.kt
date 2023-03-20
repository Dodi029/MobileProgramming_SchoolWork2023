package com.doyoung.andoridlab
// 매개변수가 1개임 람다 함수에 it 키워드 사용

fun main() {
    val some: (Int) -> Unit = { println(it) }
    some(10)
}