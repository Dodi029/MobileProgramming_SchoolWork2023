package com.example.practice03_lay

val data4: Int by lazy {
    println("inlazy......")
    10
}

fun main() {
    println("in main....")
    println(data4 + 10)
    println(data4 + 10)
}