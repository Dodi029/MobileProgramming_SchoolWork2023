package com.example.practice_arrayfun

fun main() {
    val data1: Array<Int> = Array(3, { 0 })
    data1[0] = 10
    data1[1] = 20
    data1.set(2, 30)        // 배열에서 2번째 데이터를 30으로 설정

    println(
        """
            array size : ${data1.size}
            array data: ${data1[0]}, ${data1[1]}, ${data1.get(2)}
        """
    )



    val data2: IntArray = IntArray(3, { 0 })
    val data3: BooleanArray = BooleanArray(3, { false })


    val data4 = intArrayOf(10, 20, 30)
    val data5 = booleanArrayOf(true, false, true)


    val data6 = arrayOf<Int>(10, 20, 30)
    println(
        """
            array size : ${data1.size}
            array data : ${data1[0]}, ${data1[1]}, ${data1.get(2)}
        """
    )
}