package com.doyoung.andoridlab
// 문자열 템플릿
fun main(){
    fun sum(no: Int): Int{
        var sum = 0
        for (i in 1..no){
            sum+= i
        }
        return sum
    }

    val name: String = "kkang"
    println("name : $name, sum : ${sum(10)}, Plus : ${10 + 20}")
    // println(String.format("name : %s, sum : %d, plus : %d", name, sum(10), 10 + 20))
    // 같은 뜻
    println(String.format("name : %s, sum : %d, plus : %d", name, sum(10), 10 + 20))
}
