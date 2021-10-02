package extension_functions

fun main(){
    //a
    val nev = "Cioma Roland"
    val mono = nev.monogram()
    println(mono)

    //b
    val lista = listOf<String>("apple", "pear", "melon")
    val separatorLista = lista.longestItem("#")
    println(separatorLista)

    //c
    val lista2 = listOf<String>("apple", "pear", "strawberry", "melon")
    val longest = lista2.longest()
    println(longest)
}
fun String.monogram():String = this.split(" ").map { it.first() }.joinToString("")

fun List<String>.longestItem(separator: String):String = joinToString(separator)

fun List<String>.longest():String=this.sortedBy { it.length }.get(lastIndex)
