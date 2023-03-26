package com.example.practice03_srintemplate

fun main() {
    fun sum(no: Int): Int {
        var sum = 0
        for (i in 1..no) {
            sum += i
        }
        return sum
    }

    val name : String = "kkang"
    println("name: $name, sum : ${sum(10)}, plus : ${10 + 20}")



    val data: Nothing? = null



    fun some1(): Nothing? {
        return null
    }
    fun some2(): Nothing {
        throw Exception()
    }



    // var data1: Int = 10
    // data1 = null    // 오류

    var data2: Int? = 10
    data2 = null    // 성공
}