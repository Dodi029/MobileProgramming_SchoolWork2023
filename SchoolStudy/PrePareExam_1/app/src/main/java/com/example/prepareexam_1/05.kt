package com.example.prepareexam_1

fun hofFun(function: (Int, Int) -> Boolean, arg1:Int, arg2:Int) : () -> String { val result = if (function(arg1, arg2)) arg1
else arg2 return {"Result: $result"}
}