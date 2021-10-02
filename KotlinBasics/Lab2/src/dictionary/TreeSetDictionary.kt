package dictionary

import java.io.File
import java.util.*

object TreeSetDictionary:IDictionary {

    val words = TreeSet<String>()

    init{
        File(IDictionary.fileName).readLines().forEach{add(it) }
    }
    override fun add(word: String): Boolean {
        if (find(word)==false) {
            words.add(word)
            return true
        }else{
            return false
        }
    }

    override fun find(word: String): Boolean {
        return words.contains(word)
    }

    override fun size(): Int {
        return words.size
    }
}