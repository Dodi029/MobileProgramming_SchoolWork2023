package com.doyoung.andoridlab
// 컬렉션 타입
// 배열은 Array 클래스로 표현
// 배열의 데이터에 접근할 때는 대괄호([])를 이용해도 되고 set()이나 get()함수를 이용할 수도 있음

fun main(){
    val data1: Array<Int> = Array(3, {0})
    data1[0] = 10
    data1[1] = 20
    data1.set(2, 30)

    println(
        """
    array size : ${data1.size}
    array data : ${data1[0]}, ${data1[1]}, ${data1.get(2)}
        """
    )

    val data2: IntArray = IntArray(3, {0})
    val data3: BooleanArray = BooleanArray(3, {false})

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