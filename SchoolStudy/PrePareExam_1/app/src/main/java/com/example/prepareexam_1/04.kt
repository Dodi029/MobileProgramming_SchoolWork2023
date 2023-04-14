package com.example.prepareexam_1

class MyMath{
    companion object {
        fun Add(a: Int, b: Int): Int {
            return a + b
        }

        fun Sub(a: Int, b: Int): Int {
            return a - b
        }

        fun Mul(a: Int, b: Int): Int {
            return a * b
        }

        fun Div(a: Int, b: Int): Int {
            return a / b
        }
    }
}

fun main() {
    println(MyMath.Add(10, 5))
    println(MyMath.Sub(10, 5))
    println(MyMath.Mul(10, 5))
    println(MyMath.Div(10, 5))
}
