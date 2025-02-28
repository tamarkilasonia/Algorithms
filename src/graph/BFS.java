package graph;

import java.util.*;

public class BFS {

    // Function to perform BFS traversal from a given source node
    public static void bfs(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            // Traverse all the neighbors of the current node
            for (int i = 0; i < n; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
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

        System.out.println("Breadth-First Search starting from node 0:");
        bfs(graph, 0);  // Output: 0 1 3 2 4
    }
}
