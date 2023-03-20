package com.doyoung.andoridlab

fun main() {
    var sum = 0

    for (i in 1..11 step 2){
        sum += i
        println("1부터 ${i}까지 홀수 값만를 더한 값은 ${sum}이다.")
    }
}