package graph;

import java.util.*;

public class DFS {

    // Function to perform DFS traversal from a given source node
    public static void dfs(int[][] graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        // Visit all the neighbors of the current node
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1, 0},  // Node 0 is connected to 1 and 3
                {1, 0, 1, 1, 0},  // Node 1 is connected to 0, 2, and 3
                {0, 1, 0, 0, 1},  // Node 2 is connected to 1 and 4
                {1, 1, 0, 0, 0},  // Node 3 is connected to 0 and 1
                {0, 0, 1, 0, 0}   // Node 4 is connected to 2
        };

        boolean[] visited = new boolean[graph.length];
        System.out.println("Depth-First Search starting from node 0:");
        dfs(graph, 0, visited);  // Output: 0 1 2 4 3
    }
}
