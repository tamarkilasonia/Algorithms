package graph;

import java.util.*;

public class PrimMST {

    // Function to perform Prim's Algorithm to find MST
    public static void primMST(int[][] graph) {
        int V = graph.length;
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];

        // Initialize key values and parent array
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            // Find the vertex with the minimum key value
            int u = minKey(key, inMST, V);

            // Include this vertex in MST
            inMST[u] = true;

            // Update key values and parent array
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        // Print the edges of the MST
        System.out.println("Edges in the MST:");
        for (int i = 1; i < V; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " with weight: " + graph[i][parent[i]]);
        }
    }

    // Helper function to find the vertex with the minimum key value
    private static int minKey(int[] key, boolean[] inMST, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0, 0},
                {2, 0, 3, 8, 5, 0},
                {0, 3, 0, 0, 7, 0},
                {6, 8, 0, 0, 9, 10},
                {0, 5, 7, 9, 0, 4},
                {0, 0, 0, 10, 4, 0}
        };

        primMST(graph);
    }
}
