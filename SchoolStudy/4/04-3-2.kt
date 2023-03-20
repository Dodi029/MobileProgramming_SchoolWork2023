package com.doyoung.andoridlab

open class Super2 {
    open var data =10
    open fun some() {
        println("i am super some() : $data")
    }
}
val obj = object : Super2() {
    override var data = 20
    override fun some() {
        println("i am object some() : $data")
    }
}
fun main() {
    obj.data = 30
    obj.some()
}