package com.example.myapplication

fun hotFun(function:(Int,Int) -> Boolean,arg1:Int, arg2:Int) : () -> String{
    val result = if (function(arg1, arg2)) arg1
                    else arg2
    return {"Result: $result"}
}

fun main() {
    println(hotFun({a,b ->a >b}, 10, 20)())
    println(hotFun({a,b ->a > b},20, 10)())
    println(hotFun({a,b -> a> b},20,20)())
}