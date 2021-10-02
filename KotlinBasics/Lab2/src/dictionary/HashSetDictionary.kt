package dictionary

import java.io.File
import java.util.*
import kotlin.collections.HashSet

object HashSetDictionary:IDictionary {

    val words = HashSet<String>()

    init{
        File(IDictionary.fileName).readLines().forEach{ add(it) }
    }
    override fun add(word: String): Boolean {
        if (!find(word)){
            words.add(word)
            return true
        }
        return false
    }

    override fun find(word: String): Boolean {
        return words.contains(word)
    }

    override fun size(): Int {
        return words.size
    }
}