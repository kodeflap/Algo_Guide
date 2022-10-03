package com.dlight.algoguide.dsa.graph.depth_first_search

/**
 * DepthFirstSearch
 *
 * A class carrying functionality to perform depth first search
 *
 * @constructor Creates an instance of the DepthFirstSearch class
 */
class DepthFirstSearch {
    /**
     * Function to perform depth first search
     * @param adj Adjacency list of the graph
     * @param target Value to be searched in the given graph
     * @return true if the target value is found otherwise false
     */
    fun depthFirstSearch(adj : List<List<Int>>, target: Int): Boolean {
        val visited = BooleanArray(adj.size) { false }
        return depthFirstSearch(0, target, adj, visited)
    }

    /**
     * Helper function for performing depth first search
     * @param i The node of graph that is to be explored
     * @param target Value to be searched in the given graph
     * @param adj Adjacency list of the graph
     * @param visited Boolean array used to depict whether a node is visited or not
     * @return true if the target value is found otherwise false
     */
    private fun depthFirstSearch(i: Int, target: Int, adj: List<List<Int>>, visited: BooleanArray): Boolean {

        // Mark the current node as visited
        visited[i] = true

        // If the current value is equal to the target, we have found the target so we return true
        if(i == target)
            return true

        // We explore the nodes adjacent to the current node
        for(j in adj[i]) {

            // If the target is found while exploring the adjacent nodes, we return true
            if(!visited[j] && depthFirstSearch(j, target, adj, visited))
                return true

        }

        // If the target isn't found, we return false
        return false
    }
}