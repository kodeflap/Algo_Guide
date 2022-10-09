package com.dlight.algoguide.dsa.tree.binary_tree

class Node(var key: Int) {
    var left: Node?
    var right: Node? = null

    init {
        left = right
    }
}

class BinaryTree {
    // Root of Binary Tree
    var root: Node? = null

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    // Wrappers over above recursive functions
    @JvmOverloads
    fun printPostorder(node: Node? = root) {
        if (node == null) return

        // first recur on left subtree
        printPostorder(node.left)

        // then recur on right subtree
        printPostorder(node.right)

        // now deal with the node
        print(node.key.toString() + " ")
    }

    /* Given a binary tree, print its nodes in inorder*/
    @JvmOverloads
    fun printInorder(node: Node? = root) {
        if (node == null) return

        /* first recur on left child */printInorder(node.left)

        /* then print the data of node */print(node.key.toString() + " ")

        /* now recur on right child */printInorder(node.right)
    }

    /* Given a binary tree, print its nodes in preorder*/
    @JvmOverloads
    fun printPreorder(node: Node? = root) {
        if (node == null) return

        /* first print data of node */print(node.key.toString() + " ")

        /* then recur on left subtree */printPreorder(node.left)

        /* now recur on right subtree */printPreorder(node.right)
    }

    companion object {
        // Driver method
        @JvmStatic
        fun main(args: Array<String>) {
            val tree = BinaryTree()
            tree.root = Node(1)
            tree.root!!.left = Node(2)
            tree.root!!.right = Node(3)
            tree.root!!.left!!.left = Node(4)
            tree.root!!.left!!.right = Node(5)
            println(
                "Preorder traversal of binary tree is "
            )
            tree.printPreorder()
            println(
                "\nInorder traversal of binary tree is "
            )
            tree.printInorder()
            println(
                "\nPostorder traversal of binary tree is "
            )
            tree.printPostorder()
        }
    }
}