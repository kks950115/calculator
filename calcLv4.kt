package com.example.kote

import java.time.LocalDate
import kotlin.text.*

fun main() {
    //var absOper :AbstractOperation
    val calc = Calcuator2()
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

class Calcuator2 {
    fun run2(num1: Double, num2: Double, oper: String):Double {
        var add = AddOperation2()
        var substract = SubstractOperation2()
        var multiple = MultiplyOperation2()
        var divide =  DivideOperation2()

        var result = when (oper) {
            "+" -> add.operation(num1,num2)
            "-" -> substract.operation(num1,num2)
            "*","x","X" -> multiple.operation(num1,num2)
            "/","÷" -> divide.operation(num1,num2)
            "%" -> num1%num2
            else -> 0
        }
        return result.toDouble()
    }
}

abstract class AbstractOperation {
    abstract fun operation (num1:Double ,num2:Double):Double

}

class AddOperation2 : AbstractOperation() {
    override fun operation(num1:Double ,num2:Double):Double = (num1+num2).toDouble()
}

class SubstractOperation2: AbstractOperation() {
    override fun operation(num1:Double ,num2:Double):Double = (num1-num2).toDouble()
}

class MultiplyOperation2: AbstractOperation() {
    override fun operation(num1:Double ,num2:Double):Double = (num1*num2).toDouble()
}

class DivideOperation2: AbstractOperation() {
    override fun operation(num1:Double ,num2:Double):Double = (num1/num2).toDouble()
}