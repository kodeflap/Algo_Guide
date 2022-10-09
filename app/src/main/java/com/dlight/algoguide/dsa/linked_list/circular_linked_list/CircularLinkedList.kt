package com.dlight.algoguide.dsa.linked_list.circular_linked_list
class LinkNode(var data: Int) {
    var next: LinkNode ? = null

}
class CircularLinkedList {
    private var head: LinkNode ?
    private var tail: LinkNode ?

    init {
        this.head = null
        this.tail = null
    }
    // Add node at the end position
    fun insert(value: Int) {
        val node = LinkNode(value)
        if (this.head == null)
        {
            this.head = node
        }
        else
        {
            this.tail?.next = node
        }
        node.next = this.head
        this.tail = node
    }
    // Display node element of circular linked list
    fun display() {
        if (this.head == null)
        {
            println(" Empty Linked List")
        }
        else
        {
            print("\n Linked List Element \n")
            // First node of linked list
            print("  " + this.head?.data)
            var temp: LinkNode ? = this.head?.next
            // Display linked list node
            while (temp != null && temp != this.head)
            {
                // Display node value
                print("  " + temp.data)
                // visit to next node
                temp = temp.next
            }
        }
    }
    fun searchElement(value: Int) {
        if (this.head == null)
        {
            println(" Empty Linked List")
        }
        else
        {
            var temp: LinkNode ? = this.head
            // Find node
            while (temp != null)
            {
                if (temp.data == value)
                {
                    print("\n Node value $value exist ")
                    return
                }
                // Visit to next node
                temp = temp.next
                if (temp == this.head)
                {
                    // When node are not exist
                    print("\n Node value $value are not exist ")
                    return
                }
            }
        }
    }
}
fun main() {
    val cll = CircularLinkedList()
    // First linked list
    cll.insert(9)
    cll.insert(4)
    cll.insert(7)
    cll.insert(8)
    cll.insert(1)
    cll.insert(11)
    cll.insert(3)
    cll.display()
    // Test
    cll.searchElement(4)
    cll.searchElement(34)
    cll.searchElement(11)
}