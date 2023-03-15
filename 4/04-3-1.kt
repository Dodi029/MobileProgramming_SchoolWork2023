package com.doyoung.andoridlab
// 객체의 데이터를 비교하는 equals() 함수

import org.apache.http.params.CoreConnectionPNames

class NonDataClass(val name: String, val email: String, val age: Int)
data class DataClass(val name: String, val email: String, val age: Int)

fun main() {
    val non1 = NonDataClass("kkang", "a@a.com", 10)
    val non2 = NonDataClass("kkang", "a@a.com", 10)

    val data1 = DataClass("kkang", "a@a.com", 10)
    val data2 = DataClass("kkang", "a@a.com", 10)

    println("non data class equals : ${non1.equals(non2)}")
    println("data class equals : ${data1.equals(data2)}")

    println("non data class toString : ${non1.toString()}")         // 객체의 주소값 출력
    println("data class toString : ${data1.toString()}")            // 데이터 값 출력 
}