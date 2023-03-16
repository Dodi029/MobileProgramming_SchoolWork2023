package com.doyoung.andoridlab

fun main() {
    val some = {no1: Int, no2: Int ->
        println("in lambda function")
        no1 * no2
    }
    println("result : ${some(10, 20)}")
}