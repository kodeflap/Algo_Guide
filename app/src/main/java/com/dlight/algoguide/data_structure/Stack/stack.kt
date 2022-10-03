import java.util.ArrayList

class stack<E>(var sz: Int) {
   private var arrayList: ArrayList<E> = ArrayList()
    fun push(item: E): E? {
        if (isFull) {
            println("STACK IS FULL")
            return null
        }
        arrayList.add(item)
        return item
    }

    fun pop(): E? {
        if (isEmpty) {
            return null
        }
        val len = size()
        val obj: E? = peek()
        arrayList.removeAt(len - 1)
        return obj
    }

    fun peek(): E? {
        val len = size()
        if (isEmpty) {
            return null
        }
        return arrayList[len - 1]
    }

    val isFull: Boolean
        get() = sz == arrayList.size
    val isEmpty: Boolean
        get() = arrayList.size == 0

    private fun size(): Int {
        return arrayList.size
    }

}

fun main() {
    val st  = stack<Int>(5);
    st.isEmpty
    st.isFull
    st.push(54)
    st.push(58)
    st.push(45)
    st.push(78)
    println(st.peek())
    println(st.pop())
    println(st.pop())
}