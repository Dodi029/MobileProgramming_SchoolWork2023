package com.doyoung.andoridlab
// Map 객체는 키와 값으로 이루어진 데이터의 집합
// Map 객체의 키와 값은 Pair 객체를 이용할 수 있고 '키 to 값' 형태로 이용할 수 있음

fun main() {
    var map1 = mapOf<String, String>(Pair("one", "hello"), "two" to "world")
    println(
        """
    map size : ${map1.size}
    map data : ${map1.get("one")}, ${map1.get("two")}
        """
    )

    val map2 = mutableMapOf<String, String>("1" to "hello", "2" to "world")
    map2.put("3", "test")

    println("${map2["1"]}, ${map2.get("2")}, ${map2["3"]}")
}