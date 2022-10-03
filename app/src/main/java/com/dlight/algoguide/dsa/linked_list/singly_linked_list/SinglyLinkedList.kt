package com.dlight.algoguide.dsa.linked_list.singly_linked_list

class Node<T>(value: T){
    var value:T = value
    var nextNode: Node<T>? = null
    var prev:Node<T>? = null
}
class LinkedList<T> {
    private var head:Node<T>? = null
    
    var isEmpty:Boolean = head == null
    
    fun first():Node<T>? = head
    
    fun clear() {
        this.head = null
    }

    fun last(): Node<T>? {
            var node = head
            if (node != null){
                while (node?.nextNode != null) {
                    node = node?.nextNode
                }
                return node
            } else {
                return null
            }
    }

    fun append(value: T) {
      
        var new = Node(value)
        var lastNode = this.last()
        
        if (lastNode != null) {
            new.prev = lastNode
            lastNode.nextNode = new
        } else {
            head = new
        }
    }
    
    fun removeNode(node: Node<T>):T {
        val prev = node.prev
        
        val nextNode = node.nextNode
        if (prev != null) {
            prev.nextNode = nextNode
        } else {
            head = nextNode
        }
        nextNode?.prev = prev
        node.prev = null
        node.nextNode = null
        return node.value
    }
    fun removeLast() : T? {
        val last = this.last()
        if (last != null) {
            return removeNode(last)
        } else {
            return null
        }
    }

    override fun toString(): String {
        var s = ""
        var node = head
        while (node != null) {
            s += "${node.value}"
            node = node.nextNode
            if (node != null) { s += " -> " }
        }
        return s
    }
}
fun main() {
    var LinkedList = LinkedList<String>()
    LinkedList.append("Ruchit")
    LinkedList.append("Pokhrel")
    LinkedList.append("Kumar")
    LinkedList.append("Rathode")
    LinkedList.append("Singh")
    LinkedList.append("Rajput")
    println(LinkedList)
  
    LinkedList.clear()
}
