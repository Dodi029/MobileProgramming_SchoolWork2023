package com.doyoung.andoridlab
// 조건문과 반복문
// 컬렉션 타입의 데이터 개수만큼 반복
// indices는 컬렉션 타입의 인덱스 값을 의미
// 인덱스와 실제 데이터를 함께 가져오려면 whitIndex() 함수를 이용

fun main() {
    var data1 = arrayOf<Int>(10, 20, 30)
    for (i in data1.indices) {
        print(data1[i])
        if (i !== data1.size -1) print(", ")
    }


    val data2 = arrayOf(10, 20, 30)

    for (i in data2){
        println(i)
    }
    for (i in data2.indices){
        println(data2[i])
    }
    for ((i, value) in data2.withIndex()){
        println("$i, $value")
    }


    var data3 = arrayOf<Int>(10, 20, 30)
    for ((index, value) in data3.withIndex()){
        print(value)
        if (index !== data3.size -1) print(", ")
    }
}