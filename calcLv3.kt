package com.example.kote

import kotlin.text.*

fun main() {
    val calc = Calcuator()
    println("숫자를 입력해주세요 \n")
    var num1:Double = readLine()!!.toDouble()
    println("연산자를 입력해주세요 \n" +
            "$num1 ")
    val oper :String = readLine()!!
    println("숫자를 입력해주세요 \n" +
            "$num1 $oper")
    val num2 :Double = readLine()!!.toDouble()

    println("계산결과 \n" +
            "$num1 $oper $num2 = ${calc.run2(num1,num2,oper)}")
}

class Calcuator {
    fun run2(num1: Double, num2: Double, oper: String):Double {
        var result = when (oper) {
            "+" -> addOperation(AddOperation(),num1,num2)
            "-" -> substractOperation(SubstractOperation(),num1,num2)
            "*","x","X" -> multiplyOperation(MultiplyOperation(),num1,num2)
            "/","÷" -> divideOperation(DivideOperation(),num1,num2)
            "%" -> num1 % num2
            else -> 0
        }
        return result.toDouble()
    }
    fun addOperation(obj:AddOperation, num1:Double ,num2:Double):Double = obj.add(num1 ,num2)

    fun substractOperation(obj:SubstractOperation, num1:Double ,num2:Double):Double = obj.substract(num1 ,num2)

    fun multiplyOperation(obj:MultiplyOperation, num1:Double ,num2:Double):Double = obj.multiply(num1 ,num2)

    fun divideOperation(obj:DivideOperation, num1:Double ,num2:Double):Double = obj.divide(num1 ,num2)

}


class AddOperation {
    fun add(num1:Double ,num2:Double):Double = (num1+num2).toDouble()
}

class SubstractOperation {
    fun substract(num1:Double ,num2:Double):Double = (num1-num2).toDouble()
}

class MultiplyOperation {
    fun multiply(num1:Double ,num2:Double):Double = (num1*num2).toDouble()
}

class DivideOperation {
    fun divide(num1:Double ,num2:Double):Double = (num1/num2).toDouble()
}