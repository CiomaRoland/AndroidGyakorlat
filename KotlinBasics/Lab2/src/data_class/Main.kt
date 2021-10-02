package data_class

import kotlin.random.Random

fun main(){
    //a
    val date: Date = Date(2021,2,29)
    //b
    if (date.leapYear()==true){
        println("A ${date.year} szokoev")
    }else{
        println("A ${date.year} nem szokoev")
    }
    //c
    if (date.validDate()==true){
        println("A ${date} valodi datum")
    }else{
        println("A ${date} nem valodi datum")
    }
    //d
    var i=0
    val validDates = mutableListOf<Date>()
    while(i<10){
        val year = Random.nextInt(-50,2021)
        val month = Random.nextInt(-12,20)
        val day = Random.nextInt(-10,35)
        val datum: Date = Date(year,month,day)
        if(datum.validDate()==true){
            validDates.add(datum)
            i++
        }else{
            println(datum)
        }
    }
    //e
    println("Valodi datumok:")
    validDates.forEach{
        println(it)
    }
    //f
    println("Valodi datumok rendezve:")
    validDates.sort()
    validDates.forEach{
        println(it)
    }
    //g
    println("Valodi datumok rendezve forditott sorrendben:")
    validDates.reverse()
    validDates.forEach{
        println(it)
    }
    //h
    println("Valodi datumok rendezve ismet")
    val compareDates = ComparatorDate()
    validDates.sortWith(compareDates)
    validDates.forEach{
        println(it)
    }
}
fun Date.leapYear():Boolean{
    if(this.year.mod(4)==0 && this.year.mod(100)==0 && this.year.mod(400)==0) {
        return true
    }
    if(this.year.mod(4)==0 && this.year.mod(100)==0 && this.year.mod(400)!=0) {
        return false
    }
    if(this.year.mod(4)==0 && this.year.mod(100)!=0 && this.year.mod(400)!=0) {
        return true
    }
    return false
}
fun Date.validDate():Boolean{
    //ellenorzom az evet
    if(this.year<0){
        return false
    }
    //ellenorzom a honapot
    if(this.month<1 || this.month>12){
        return false
    }
    //ellenorzom a napot
    val honapNapjai = listOf(31,if(this.leapYear()==true) 29 else 28,31,30,31,30,31,31,30,31,30,31)
    if (this.day<1 || this.day>honapNapjai[this.month-1]){
        return false
    }
    return true
}
