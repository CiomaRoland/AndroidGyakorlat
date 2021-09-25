package fundamentals

import java.util.*


fun main(){
    //fel1
    fel1()

    //fel2
    fel2()

    //fel3
    val num = 53
    fel3(num)

    //fel4
    fel4()

    //fel5
    fel5()

    //fel6
    fel6()

    //fel7
    fel7()

    //fel8
    fel8()
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
fun encodeStr(originalStr : String): String{
    val encodedString = Base64.getEncoder().encodeToString(originalStr.toByteArray())
    return encodedString
}
fun decodeStr(encodedString : String): String{
    val decodedBytes = Base64.getDecoder().decode(encodedString)
    val decodedString = String(decodedBytes)
    return decodedString
}
fun messageCoding(msg: String, func: (String) -> String): String{
    return func(msg)
}


fun fel4(){
    val originalStr="Hello Kotlin"
    println(originalStr)
    val encStr = encodeStr(originalStr)
    println(encStr)
    val decStr = decodeStr(encStr)
    println(decStr)

    val resStr = messageCoding(originalStr, ::encodeStr)
}
fun filterEven(listNumber: List<Int>): List<Int> = listNumber.filter { it.mod(2) == 0 }  //fel5-ben hasznalom

fun fel5(){
    val listNumber = listOf(1,2,3,4,5,6,7,8,9)
    val evenNumber = filterEven(listNumber)
    for (n in evenNumber){
        print("$n ")
    }
    println()
}

fun fel6() {
    //a
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val doubleElements = numbers.map { it -> it * 2 }
    for (num in doubleElements) {
        print("$num ")
    }
    println()

    //b
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val capitalizedDays = daysOfWeek.map { it -> it.toUpperCase() }
    for (day in capitalizedDays) {
        print("$day ")
    }
    println()

    //c
    val firstCharDays = daysOfWeek.map { it -> it.first() }.map { it -> it.toLowerCase() }
    for (day in firstCharDays) {
        print("$day ")
    }
    println()

    //d
    val lenghtDays = daysOfWeek.map { it -> it.length }
    for (day in lenghtDays) {
        print("$day ")
    }
    println()
}
fun fel7(){
    //a
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val mutableOneDays = daysOfWeek.toMutableList()
    val removeLetterN = mutableOneDays.filter { !it.contains("n") }
    for( day in removeLetterN){
        print("$day ")
    }
    println()

    //b
    for ((index, day) in removeLetterN.withIndex()){
        println("Item at $index is $day")
    }

    //c
    val sortDays = removeLetterN.sorted()
    for( day in sortDays){
        print("$day ")
    }
    println()
}
fun fel8(){
    //a
    val randomIntegers = List(10) { Random().nextInt(100) }
    for (n in randomIntegers){
        println(n)
    }

    //b
    val ascendingOrders = randomIntegers.sorted()
    for (n in ascendingOrders){
        print("$n ")
    }
    println()

    //c
    var even=false
    for (n in randomIntegers){
        if (n.mod(2)==0){
            even=true
            break
        }
    }
    if (even == true){
        println("A tomb tartalmaz paros elemet!")
    }else{
        println("A tomb nem tartalmaz paros elemet!")
    }

    //d
    var allEven=true
    for (n in randomIntegers){
        if (n.mod(2)!=0){
            allEven=false
            break
        }
    }
    if (allEven == true){
        println("A tomb minden eleme paros!")
    }else{
        println("A tomb nem minden eleme paros!")
    }

    //d
    var sum =0;
    for (n in randomIntegers){
        sum+=n
    }
    print("A szamok atlaga: ${sum/randomIntegers.size}")
}