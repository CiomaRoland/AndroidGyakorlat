package fundamentals

import java.util.*
import kotlin.math.sqrt

fun main(){
    fel1()
    fel2()
    fel3(53)
}
fun fel1(){
    val x1 = 2
    val x2 = 3
    println("$x1 + $x2 = ${x1+x2}")
}
fun fel2(){
    //a
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    for (day in daysOfWeek){
        print(day + " ")
    }
    println()

    //b
    val filterLetterT = daysOfWeek.filter { it.startsWith("T") }
    for (day in filterLetterT){
        print(day + " ")
    }
    println()

    //c
    val filterLettere = daysOfWeek.filter { it.contains("e") }
    for (day in filterLettere){
        print(day + " ")
    }
    println()

    //d
    val filterLength = daysOfWeek.filter { it.length ==6 }
    for (day in filterLength){
        print(day + " ")
    }
    println()
}
fun isPrime(num : Int): Boolean{
    var primeV = true
    for (i in 2..num/2){
        if (num.mod(i)==0){
            return false
        }
    }
    return primeV
}
fun fel3(szam : Int){
    if (isPrime(szam)){
        println("A $szam prim")
    }else {
        println("A $szam nem prim")
    }
}
fun fel4(msg : String){

}