package com.doyoung.andoridlab
// 엘비스 ㅡ?: 연산자

fun main() {
    var data: String? = "kkang"
    println("data = $data : ${data?.length ?: -1}")
    data =  null
    println("data + $data : ${data?.length ?: -1}")
}