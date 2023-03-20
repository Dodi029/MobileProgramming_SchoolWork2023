package com.doyoung.andoridlab

class User4 {
    constructor(name: String) {
        println("constructor(name: String) call...")
    }
    constructor(name: String, count: Int) {
        println("constructor(name: String, count: Int) call")
    }
}
fun main(){
    val user1 = User4("kkang")
    val user2 = User4("kkang", 10)
}