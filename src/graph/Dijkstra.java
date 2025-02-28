package graph;

import java.util.*;

public class Dijkstra {

    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        boolean[] visited = new boolean[n];

        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(dist, visited, n);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Shortest distances from source node " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    private static int minDistance(int[] dist, boolean[] visited, int n) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < n; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0},  // Node 0
                {4, 0, 8, 0, 0, 0},  // Node 1
                {0, 8, 0, 7, 0, 4},  // Node 2
                {0, 0, 7, 0, 9, 14}, // Node 3
                {0, 0, 0, 9, 0, 10}, // Node 4
                {0, 0, 4, 14, 10, 0} // Node 5
        };

        dijkstra(graph, 0);  // Output shortest paths from node 0
    }
}
