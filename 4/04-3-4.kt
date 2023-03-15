package com.doyoung.andoridlab

abstract class Animal2 {
    var name : String = ""
    abstract fun move()
}
interface iAnimal {
    abstract fun eat()
}

class iCat : iAnimal {
    override fun eat() {
        println("생선을 좋아한다.")
    }
}

class iTiger : Animal2(), iAnimal {
    override fun move() {
        println("네 발로 이동한다.")
    }
    override fun eat() {
        println("멧돼지를 잡아먹는다. ")
    }
}

class Eagle2 : Animal() {
    var home : String = ""
    override fun move() {
        println("날개로 날아간다, ")
    }
}

fun main() {
    var cat = iCat()
    cat.eat()

    var tiger = iTiger()
    tiger.move()
    tiger.eat()
}