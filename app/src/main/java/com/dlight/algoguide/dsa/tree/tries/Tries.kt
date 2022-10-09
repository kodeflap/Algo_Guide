package com.dlight.algoguide.dsa.tree.tries

object Trie_Array {
    @JvmStatic
    fun main(args: Array<String>) {
        val tr = Trie_Ar()
        tr.insert("antman")
        tr.insert("ant")
        tr.insert("batman")
        tr.insert("bat")
        tr.insert("batball")
        tr.insert("pranay")
        tr.insert("anu")
        tr.insert("test")
        tr.insert("testing")
        println(tr.search("hello"))
        println(tr.search("ant"))
        println(tr.search("bat"))
        println(tr.search("antman"))
        println(tr.search("pranay"))
        println(tr.startsWith("an"))
        println(tr.startsWith("prana"))
        println(tr.startsWith("bat"))
        // checking delete function
        println(tr.search("ant"))
        tr.delete("ant")
        println(tr.search("ant"))
    }
}

internal class Trie_Ar {
    internal inner class Node(var data: Char) {
        var next: Array<Node?>
        var count // this will keep the count for the no. of words formed using particular character
                : Int
        var isEnd: Boolean

        init {
            next = arrayOfNulls(26)
            isEnd = false
            count = 0
        }
    }

    var root: Node

    init {
        root = Node('\u0000')
    }

    fun insert(word: String) {
        var curr: Node? = root
        for (c in word.toCharArray()) {
            if (curr!!.next[c - 'a'] == null) curr.next[c - 'a'] = Node(c)
            curr.next[c - 'a']!!.count++
            curr = curr.next[c - 'a']
        }
        curr!!.isEnd = true //this marks the end of the word, so now the word exists in the trie
    }

    fun search(word: String): Boolean {
        var curr: Node? = root
        for (c in word.toCharArray()) {
            if (curr!!.next[c - 'a'] == null) return false
            curr = curr.next[c - 'a']
        }
        return curr!!.isEnd
    }

    // return true if any word with "prefix" is present in trie
    fun startsWith(prefix: String): Boolean {
        var curr: Node? = root
        for (c in prefix.toCharArray()) {
            if (curr!!.next[c - 'a'] == null) return false
            curr = curr.next[c - 'a']
        }
        println("No. of string formed using prefix - '" + prefix + "' is = " + curr!!.count)
        return true
    }

    fun delete(word: String) {
        if (search(word)) {
            var curr: Node? = root
            for (c in word.toCharArray()) {
                curr = curr!!.next[c - 'a']
            }
            curr!!.isEnd =
                false //this unmarks the end of word, so now the entire word is non-existent in the trie
            println("Deleted")
        } else {
            println("Word not fount")
            return
        }
    }
}