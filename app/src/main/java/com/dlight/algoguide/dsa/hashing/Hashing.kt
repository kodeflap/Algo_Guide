package com.dlight.algoguide.dsa.hashing

class HashMap<K, V>() {
    var buckets: ArrayList<MapNode<K, V>?>
    var size // number of entries
            = 0
    var numBuckets // number of buckets
            = 5

    init {
        buckets = ArrayList()
        for (i in 0 until numBuckets) {
            buckets.add(null)
        }
    }

    private fun getBucketIndex(key: K): Int {
        val hashCode = key.hashCode()
        return hashCode % numBuckets
    }

    fun size(): Int {
        return size
    }

    fun loadFactor(): Double {
        return size.toDouble() / numBuckets
    }

    private fun rehash() {
        println(
            "\nNumber of Entries = " + size + "\nNumber of Buckets = " + numBuckets + "\nLoad Factor = "
                    + size.toDouble() / numBuckets
        )
        val temp = buckets
        buckets = ArrayList()
        for (i in 0 until (2 * numBuckets)) {
            buckets.add(null)
        }
        size = 0
        numBuckets *= 2
        for (i in 0 until temp.size) {
            var curr = temp[i]
            while (curr != null) {
                val key = curr.key
                val value = curr.value
                insert(key, value)
                curr = curr.next
            }
        }
    }

    fun insert(key: K, value: V) {
        val bucketIndex = getBucketIndex(key)
        var curr = buckets[bucketIndex] // curr is a pointer which will be used to traverse the
        // LinkedList

        // traverse through the LinkedList, if the key is found then update it's value
        while (curr != null) {
            if ((curr.key == key)) {
                curr.value = value
                return
            }
            curr = curr.next
        }
        // if the control comes here, this means that the key is not present in the Map,
        // so we will create a new MapNode
        curr = buckets[bucketIndex]
        val newElementNode = MapNode(key, value)
        newElementNode.next = curr
        buckets[bucketIndex] = newElementNode
        size++
        val loadFactor = size.toDouble() / numBuckets
        if (loadFactor > 0.7) rehash()
    }

    fun containsKey(key: K): Boolean {
        val index = getBucketIndex(key)
        var curr = buckets[index] // this is a pointer which will traverse
        while (curr != null) {
            // here equals method can be override if you want to use your using your own
            // class object else Wrapper class like INTEGER, DOUBLE..have their own equals()
            if ((curr.key == key)) {
                return true
            }
            curr = curr.next
        }
        return false
    }

    fun getValue(key: K): V? {
        val bucketIndex = getBucketIndex(key)
        var curr = buckets[bucketIndex] // curr is a pointer which will be used to traverse the
        // LinkedList

        // traverse through the LinkedList, if the key is found then return its value
        while (curr != null) {
            if ((curr.key == key)) {
                return curr.value
            }
            curr = curr.next
        }
        return null
    }

    fun remove(key: K): V? {
        val bucketIndex = getBucketIndex(key)
        // curr is a pointer which will be used to traverse the LinkedList
        var curr = buckets[bucketIndex]
        // prev is another pointer which will be used to store the location of the
        // previous node
        var prev: MapNode<K, V>? = null

        // traverse through the LinkedList, if the key is found then return its value
        while (curr != null) {
            if ((curr.key == key)) {
                if (prev == null) buckets[bucketIndex] = curr.next else prev.next = curr.next
                size--
                return curr.value
            }
            prev = curr
            curr = curr.next
        }
        return null
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val map: HashMap<Any, Any> = HashMap<Any, Any>()
            for (i in 1..20) {
                map.insert("abc$i", i)
                println("For Entry " + i + " LoadFactor = " + map.loadFactor())
            }
            println(map.containsKey("abc5"))
            map.remove("abc8")
            map.remove("abc9")
            map.remove("abc8")
            for (i in 0 until map.size()) {
                println("abc" + i + ":" + map.getValue("abc$i"))
            }
        }
    }
}

class MapNode<K, V>(var key: K, var value: V) {
    var next: MapNode<K, V>? = null
}