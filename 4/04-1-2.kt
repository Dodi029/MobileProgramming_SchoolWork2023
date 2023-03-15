package com.doyoung.andoridlab

class User(name : String, count : Int) {
    init {
        println("i am init..")
    }
}
fun main() {
    val user = User("kkang", 10)
}