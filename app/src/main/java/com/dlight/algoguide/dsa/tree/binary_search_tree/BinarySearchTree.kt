package com.dlight.algoguide.dsa.tree.binary_search_tree

import com.dlight.algoguide.dsa.tree.binary_search_tree.BST.DiaPair
import java.util.*


object BinarySearchTree {
    const val GLOBALSPACE = 5
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val bt = BST()
        var flag = true
        var inorder: IntArray
        var preorder: IntArray
        var postorder: IntArray
        while (flag) {
            var `val` = 0
            println()
            println("1  - Insert a Node(Iterative Approach): ")
            println("2  - Insert a Node(Recursive Approach): ")
            println("3  - Insert a Node(Level Order Insertion) :")
            println("4  - Print 2D :")
            println("5  - Height of Tree :")
            println("6  - Sum of all Nodes in the Tree :")
            println("7  - Print Level Order/Breadth First Search (using Queue) :")
            println("8 - Print Level Order/Breadth First Search (using Recursion) :")
            println("9 - Print a Certain Level of the Tree :")
            println("10 - Sum of values at level K :")
            println("11 - Print Pre-order Traversal :")
            println("12 - Print In-order Traversal :")
            println("13 - Print Post-order Traversal :")
            println("14 - Print all Paths from Root to Leaf Nodes :")
            println("15 - Search in Binary Search Tree(Iterative Approach) :")
            println("16 - Search in Binary Search Tree(Recursive Approach) :")
            println("17 - Diameter of Binary Tree (O(n^2) Approach) :")
            println("18 - Diameter of Binary Tree (O(n) Approach) :")
            println("19 - Delete a Node :")
            println("20 - Construct BT from Pre-Order and In-Order :")
            println("21 - Construct BT from Post-Order and In-Order :")
            println("22 - Construct BST from In-Order :")
            println("23 - Construct BST from Pre-Order :")
            println("24 - Construct BST from Post-Order :")
            println("25 - Check if the Binary Tree is Balanced :")
            println("0  - Exit")
            val ch: Int = sc.nextInt()
            when (ch) {
                1 -> {
                    print("Enter Value to Insert: ")
                    `val` = sc.nextInt()
                    bt.insertIterative(`val`)
                }
                2 -> {
                    print("Enter Value to Insert: ")
                    `val` = sc.nextInt()
                    bt.root = bt.insertRecursive(bt.root, `val`)
                }
                3 -> {
                    println("Enter Value to Insert: ")
                    `val` = sc.nextInt()
                    bt.insertLevelOrder(bt.root, `val`)
                }
                4 -> bt.print2D(bt.root, GLOBALSPACE)
                5 -> println("Height of the Tree is = " + BST.height(bt.root))
                6 -> println("Sum of all the Nodes in the Tree is = " + bt.sumOfNodes(bt.root))
                7 -> {
                    println("The Binary Tree in Level Order/Breadth First Search (using Queue) is = ")
                    bt.printLevelOrderQueue(bt.root)
                }
                8 -> {
                    println("The Binary Tree in Level Order/Breadth First Search (using Recursion) is = ")
                    bt.printLevelOrderRecursion(bt.root)
                }
                9 -> {
                    print("Enter the Level to print Level Order: ")
                    val l: Int = sc.nextInt()
                    println("The Nodes in Level-$l in Level Order are:")
                    bt.printGivenLevel(bt.root, l)
                }
                10 -> {
                    print("Enter Level(K): ")
                    `val` = sc.nextInt()
                    bt.sum = 0
                    println("Sum of values at level K is = " + bt.sumAtK(bt.root, `val`))
                }
                11 -> {
                    println("The Tree Nodes in Pre-Order Fashion = ")
                    bt.printPreOrder(bt.root)
                }
                12 -> {
                    println("The Tree Nodes in In-Order Fashion = ")
                    bt.printInOrder(bt.root)
                }
                13 -> {
                    println("The Tree Nodes in Post-Order Fashion = ")
                    bt.printPostOrder(bt.root)
                }
                14 -> {
                    println("All Paths from Root to Leaf Nodes are = ")
                    BST.rootToLeaf(bt.root)
                }
                15 -> {
                    print("Enter the Value to Search: ")
                    `val` = sc.nextInt()
                    if (bt.iterativeSearch(`val`)) println("Value Found") else println("Value Not Found")
                }
                16 -> {
                    print("Enter the Value to Search: ")
                    `val` = sc.nextInt()
                    if (bt.recursiveSearch(
                            bt.root,
                            `val`
                        ) == null
                    ) println("Value Not Found") else println("Value Found")
                }
                17 -> println(
                    "Diameter of Binary Tree (O(n^2) Approach) is = " + BST.diameterOfBT(
                        bt.root
                    )
                )
                18 -> {
                    var d = DiaPair()
                    d = BST.diameter(bt.root)
                    System.out.println("Diameter of Binary Tree (O(n) Approach) is = " + d.dia)
                }
                19 -> {
                    print("Enter Value to Delete: ")
                    `val` = sc.nextInt()
                    bt.root = bt.delete(bt.root, `val`)
                }
                20 -> {
                    print("Enter Number of Nodes in Binary Tree: ")
                    `val` = sc.nextInt()
                    preorder = IntArray(`val`)
                    inorder = IntArray(`val`)
                    println("Enter Values in Pre-Order Sequence:")
                    run {
                        var i = 0
                        while (i < `val`) {
                            preorder[i] = sc.nextInt()
                            i++
                        }
                    }
                    println("Enter Values in In-Order Sequence:")
                    var i = 0
                    while (i < `val`) {
                        inorder[i] = sc.nextInt()
                        i++
                    }
                    bt.root = bt.buildTreeFromInorderPreorder(preorder, inorder)
                }
                21 -> {
                    print("Enter Number of Nodes in Binary Tree: ")
                    `val` = sc.nextInt()
                    postorder = IntArray(`val`)
                    inorder = IntArray(`val`)
                    println("Enter Values in Post-Order Sequence:")
                    run {
                        var i = 0
                        while (i < `val`) {
                            postorder[i] = sc.nextInt()
                            i++
                        }
                    }
                    println("Enter Values in In-Order Sequence:")
                    var i = 0
                    while (i < `val`) {
                        inorder[i] = sc.nextInt()
                        i++
                    }
                    bt.root = bt.buildTreeFromInorderPostorder(postorder, inorder)
                }
                22 -> {
                    print("Enter Number of Nodes in Binary Search Tree: ")
                    `val` = sc.nextInt()
                    inorder = IntArray(`val`)
                    println("Enter Values in In-Order Sequence:")
                    var i = 0
                    while (i < `val`) {
                        inorder[i] = sc.nextInt()
                        i++
                    }
                    bt.root = bt.buildBSTfromInorder(inorder)
                }
                23 -> {
                    print("Enter Number of Nodes in Binary Search Tree: ")
                    `val` = sc.nextInt()
                    preorder = IntArray(`val`)
                    println("Enter Values in Pre-Order Sequence:")
                    var i = 0
                    while (i < `val`) {
                        preorder[i] = sc.nextInt()
                        i++
                    }
                    bt.root = bt.buildBSTfromPreorder(preorder)
                }
                24 -> {
                    print("Enter Number of Nodes in Binary Search Tree: ")
                    `val` = sc.nextInt()
                    postorder = IntArray(`val`)
                    println("Enter Values in Post-Order Sequence:")
                    var i = 0
                    while (i < `val`) {
                        postorder[i] = sc.nextInt()
                        i++
                    }
                    bt.root = bt.buildBSTfromPostorder(postorder)
                }
                25 -> {
                    BST.height(bt.root)
                    println(BST.isBal)
                    flag = false
                }
                0 -> flag = false
                else -> println("Invalid Choice.")
            }
        }
    }
}

internal class BST {
    internal inner class Node(var data: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    var root: Node? = null
    val isTreeEmpty: Boolean
        get() = root == null

    fun insertIterative(`val`: Int) {
        val n: Node = Node(`val`)
        if (isTreeEmpty) {
            root = n
            println("Value Inserted as the Root Node.")
        } else {
            var temp = root
            while (temp != null) {
                // check if the value already exists at the current node
                if (`val` == temp.data) {
                    println("Value Already Exists!")
                    return
                } else if (`val` < temp.data && temp.left == null) {
                    temp.left = n
                    println("Value inserted at the left.")
                    break
                } else if (`val` < temp.data) {
                    temp = temp.left
                } else if (`val` > temp.data && temp.right == null) {
                    temp.right = n
                    println("Value inserted at the right.")
                    break
                } else {
                    temp = temp.right
                }
            }
        }
    }

    fun insertRecursive(root: Node?, `val`: Int): Node {
        if (root == null) {
            return Node(`val`)
        }
        // if the value is less than the root node then recur for the left subtree
        if (`val` < root.data) {
            root.left = insertRecursive(root.left, `val`)
        } else {
            root.right = insertRecursive(root.right, `val`)
        }
        return root
    }

    fun insertLevelOrder(rt: Node?, `val`: Int) {
        var rt = rt
        val nn: Node = Node(`val`)
        if (rt == null) {
            rt = nn
            println("Inserted at the Root")
            root = rt
            return
        }
        val q: Queue<Node> = LinkedList<Node>()
        q.add(rt)
        while (!q.isEmpty()) {
            val n: Node = q.element()
            q.remove()
            if (n.left == null) {
                n.left = nn
                println("Value inserted at the left.")
                root = rt
                return
            } else if (n.right == null) {
                n.right = nn
                println("Value inserted at the right.")
                root = rt
                return
            } else {
                q.add(n.left)
                q.add(n.right)
            }
        }
    }

    fun print2D(r: Node?, space: Int) {
        if (r == null) // base case
            return
        print2D(r.right, space + BinarySearchTree.GLOBALSPACE)
        println()
        for (i in BinarySearchTree.GLOBALSPACE until space) print(" ")
        println(r.data)
        print2D(r.left, space + BinarySearchTree.GLOBALSPACE)
    }

    fun sumOfNodes(r: Node?): Int {
        if (r == null) {
            return 0
        }
        val lsum = sumOfNodes(r.left) // to calc the sum of left subtree
        val rsum = sumOfNodes(r.right) // to calc the sum of right subtree
        return lsum + rsum + r.data
    }

    fun printLevelOrderQueue(r: Node?) {
        var temp: Node? = null
        val queue: Queue<Node> = LinkedList<Node>()
        queue.add(r)
        while (queue.size > 0) {
            temp = queue.poll() // store the value of current node in 'temp' and dequeue it
            print(temp.data.toString() + " ") // print the current node value
            if (temp.left != null) {
                queue.add(temp.left) // enqueue the left child
            }
            if (temp.right != null) {
                queue.add(temp.right) // enqueue the right child
            }
        }
    }

    fun printLevelOrderRecursion(r: Node?) {
        val h = height(r)
        for (i in 0..h) printGivenLevel(r, i)
    }

    fun printGivenLevel(r: Node?, level: Int) {
        if (r == null) // base case
            return else if (level == 0) print(r.data.toString() + " ") else { // level > 0
            printGivenLevel(r.left, level - 1)
            printGivenLevel(r.right, level - 1)
        }
    }

    var sum = 0
    fun sumAtK(r: Node?, K: Int): Int {
        if (r == null) return sum else if (K == 0) // if K is at root level (0)
            sum = sum + r.data else {
            sumAtK(r.left, K - 1)
            sumAtK(r.right, K - 1)
        }
        return sum
    }

    fun printPreOrder(r: Node?) { // N L R
        if (r == null) return
        print(r.data.toString() + " ")
        printPreOrder(r.left)
        printPreOrder(r.right)
    }

    fun printInOrder(r: Node?) { // L N R
        if (r == null) return
        printInOrder(r.left)
        print(r.data.toString() + " ")
        printInOrder(r.right)
    }

    fun printPostOrder(r: Node?) { // L R N
        if (r == null) return
        printPostOrder(r.left)
        printPostOrder(r.right)
        print(r.data.toString() + " ")
    }

    fun iterativeSearch(`val`: Int): Boolean {
        var flag = false
        if (root == null) {
            println("Binary Search Tree is Empty")
        } else {
            var temp = root
            while (temp != null) {
                if (`val` == temp.data) { // if the node is found
                    flag = true
                    break
                } else if (`val` < temp.data) // traverse to the left-subtree
                    temp = temp.left else if (`val` > temp.data) // traverse to the right-subtree
                    temp = temp.right
            }
        }
        return flag
    }

    fun recursiveSearch(r: Node?, `val`: Int): Node? {
        if (r == null) // if the current node is null or the value is not present in the BST
            return null
        if (r.data == `val`) // if the value is found
            return r
        return if (r.data > `val`) recursiveSearch(r.left, `val`) else recursiveSearch(
            r.right,
            `val`
        )
        // when data<val then traverse to the right-subtree
    }

    internal class DiaPair {
        var ht = 0
        var dia = 0
    }

    fun delete(node: Node?, `val`: Int): Node? {
        if (node == null) return null
        if (`val` < node.data) {
            node.left = delete(node.left, `val`)
        } else if (`val` > node.data) {
            node.right = delete(node.right, `val`)
        } else {
            if (node.left != null && node.right != null) // if the node has a left and right child
            {
                val lmax = maxLeft(node.left)
                node.data = lmax
                node.left = delete(node.left, lmax)
            } else return if (node.left != null) {
                node.left
            } else if (node.right != null) {
                node.right
            } else {
                null
            }
        }
        return node
    }

    fun buildTreeFromInorderPreorder(preorder: IntArray, inorder: IntArray): Node? {
        val n = inorder.size
        println("Your BT is Ready PRESS 4 AND ENTER to View")
        return preInTree(preorder, 0, n - 1, inorder, 0, n - 1)
    }

    fun preInTree(pre: IntArray, psi: Int, pei: Int, `in`: IntArray, isi: Int, iei: Int): Node? {
        if (isi > iei) return null
        val n: Node = Node(pre[psi])
        var idx = isi
        while (`in`[idx] != pre[psi]) idx++
        val tnel = idx - isi // total no. of element on left side/right side of root.
        n.left = preInTree(pre, psi + 1, psi + tnel, `in`, isi, idx - 1)
        n.right = preInTree(pre, psi + tnel + 1, pei, `in`, idx + 1, iei)
        return n
    }

    fun buildTreeFromInorderPostorder(postorder: IntArray, inorder: IntArray): Node? {
        val n = postorder.size
        println("Your BT is Ready PRESS 4 AND ENTER to View")
        return postInTree(postorder, 0, n - 1, inorder, 0, n - 1)
    }

    fun postInTree(post: IntArray, psi: Int, pei: Int, `in`: IntArray, isi: Int, iei: Int): Node? {
        if (isi > iei) return null
        val n: Node = Node(post[pei])
        var idx = isi
        while (`in`[idx] != post[pei]) idx++
        val tnel = idx - isi // total no of elements on left side/right side of root.
        n.left = postInTree(post, psi, psi + tnel - 1, `in`, isi, idx - 1)
        n.right = postInTree(post, psi + tnel, pei - 1, `in`, idx + 1, iei)
        return n
    }

    fun buildBSTfromInorder(inorder: IntArray): Node? {
        val n = inorder.size
        println("Your BST is Ready PRESS 4 AND ENTER to View")
        return buildBSTfromInorder(inorder, 0, n - 1)
    }

    private fun buildBSTfromInorder(`in`: IntArray, si: Int, ei: Int): Node? {
        if (si > ei) return null
        val midRoot = (si + ei) / 2
        val n: Node = Node(`in`[midRoot])
        n.left = buildBSTfromInorder(`in`, si, midRoot - 1)
        n.right = buildBSTfromInorder(`in`, midRoot + 1, ei)
        return n
    }

    var idx = 0
    fun buildBSTfromPreorder(preorder: IntArray): Node? {
        val lr = -1000 // left range
        val rr = 1000 // right range
        idx = 0
        println("Your BST is ready PRESS 4 AND ENTER to view")
        return buildBSTfromPreorder(preorder, lr, rr)
    }

    private fun buildBSTfromPreorder(pre: IntArray, lr: Int, rr: Int): Node? {
        if (idx >= pre.size || pre[idx] < lr || pre[idx] > rr) return null
        val n: Node = Node(pre[idx++])
        n.left = buildBSTfromPreorder(pre, lr, n.data)
        n.right = buildBSTfromPreorder(pre, n.data, rr)
        return n
    }

    fun buildBSTfromPostorder(postorder: IntArray): Node? {
        val lr = -1000 // left range
        val rr = 1000 // right range
        idx = postorder.size - 1
        println("Your BST is Ready PRESS 4 AND ENTER to view")
        return buildBSTfromPostorder(postorder, lr, rr)
    }

    private fun buildBSTfromPostorder(post: IntArray, lr: Int, rr: Int): Node? {
        if (idx < 0 || post[idx] < lr || post[idx] > rr) return null
        val n: Node = Node(post[idx--])
        n.right = buildBSTfromPostorder(post, n.data, rr)
        n.left = buildBSTfromPostorder(post, lr, n.data)
        return n
    }

    companion object {
        var isBal = true
        fun height(r: Node?): Int {
            return if (r == null) -1 else {
                val lheight = height(r.left)
                val rheight = height(r.right)

                // exclusive for function 27, ignore this condition for finding the height
                if (Math.abs(lheight - rheight) > 1) {
                    isBal = false
                }
                //
                Math.max(lheight, rheight) + 1
            }
        }

        var st: Stack<Int> = Stack<Int>()

        // print from root to leaf node by In-Order Traversal
        fun rootToLeaf(r: Node?) {
            if (r == null) return
            st.push(r.data)
            rootToLeaf(r.left)
            if (r.left == null && r.right == null) // if the encountered node is a leaf node
            {
                System.out.println(st)
            }
            rootToLeaf(r.right)
            st.pop()
        }

        fun diameterOfBT(r: Node?): Int {
            if (r == null) return 0

            // maximum distance between two nodes of LHS (factor 1)
            val ld = diameterOfBT(r.left)

            // maximum distance between two nodes of RHS (factor 2)
            val rd = diameterOfBT(r.right)

            // maximum distance between left's deepest & right's deepest nodes (factor 3)
            val des =
                height(r.left) + height(r.right) + 2
            return Math.max(des, Math.max(ld, rd))
        }

        fun diameter(node: Node?): DiaPair {
            if (node == null) {
                val bp = DiaPair()
                bp.ht = -1
                bp.dia = 0
                return bp
            }
            val lp = diameter(node.left)
            val rp = diameter(node.right)
            val mp = DiaPair()
            mp.ht = Math.max(lp.ht, rp.ht) + 1
            val des = lp.ht + rp.ht + 2
            mp.dia = Math.max(des, Math.max(lp.dia, rp.dia))
            return mp
        }

        fun maxLeft(node: Node?): Int {
            return if (node!!.right != null) maxLeft(node.right) else node.data
        }
    }
}