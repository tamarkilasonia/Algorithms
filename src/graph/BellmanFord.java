package graph;

import java.util.*;

public class BellmanFord {

    public static void bellmanFord(int[][] graph, int V, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax edges repeatedly
        for (int i = 1; i < V; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        System.out.println("Shortest distances from source node " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, -1, 4, 0, 0, 0},
                {-1, 0, 3, 2, 2, 0},
                {4, 3, 0, 0, 0, 0},
                {0, 2, 0, 0, -1, 3},
                {0, 2, 0, -1, 0, 3},
                {0, 0, 0, 3, 3, 0}
        };

        bellmanFord(graph, 6, 0);
    }
}
