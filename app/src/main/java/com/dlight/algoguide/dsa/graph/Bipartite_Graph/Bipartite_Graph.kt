import java.util.LinkedList
import kotlin.jvm.JvmStatic

class Bipartite_Graph internal constructor(var V: Int) {
    var al: MutableList<LinkedList<Int?>>
    fun DFS(visited: BooleanArray, arr: IntArray, data: Int, par: Int): Boolean {
        visited[data] = true
        if (arr[par] == 1) {
            arr[data] = 0
        } else {
            arr[data] = 1
        }
        for (it in al[data]) {
            if (visited[it!!] == false) {
                if (DFS(visited, arr, it, data) == false) {
                    return false
                }
            } else if (it != par && arr[it] == arr[data]) {
                return false
            }
        }
        return true
    }

    fun bipartiteGraph(): Boolean {
        val visited = BooleanArray(V)
        val arr = IntArray(V)
        for (i in 0 until V) {
            arr[i] = -1
        }
        for (i in 0 until V) {
            if (visited[i] == false) {
                arr[i] = 0
                if (!DFS(visited, arr, i, i)) {
                    return false
                }
            }
        }
        return true
    }

    fun addEdge(i: Int, j: Int) {
        al.get(i).add(j)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // TODO Auto-generated method stub
            val ob = Bipartite_Graph(10)
            ob.addEdge(0, 1)
            ob.addEdge(1, 2)
            ob.addEdge(3, 4)
            ob.addEdge(4, 5)
            ob.addEdge(5, 6)
            ob.addEdge(6, 8)
            ob.addEdge(6, 7)
            ob.addEdge(6, 9)
            ob.addEdge(9, 5)

            val ans: Boolean = ob.bipartiteGraph()
            print("Is Bipartite Graph : $ans")
        }
    }

    init {
        al = mutableListOf(LinkedList<Int?>())
        for (i in 0 until V) {
            al.add(i, LinkedList<Int?>())
        }
    }
}
