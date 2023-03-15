package com.doyoung.andoridlab
// 상위 클래스에 선언된 변수나 함수를 같은 이름으로 하위 클래스에서 다시 선언하는 것을 오버라이딩이라고 함

open class Super {
    open var someData = 10
    open fun someFun() {
        println("i am super class function : $someData")
    }
}
class Sub: Super() {
    override var someData = 20
    override fun someFun() {
        println("i am sub class function : $someData")
    }
}
fun main() {
    val obj = Sub()
    obj.someFun()
}