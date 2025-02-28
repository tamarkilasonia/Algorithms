package graph;

import java.util.*;

public class KruskalMST {

    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Function to perform Kruskal's Algorithm to find MST
    public static void kruskalMST(int[][] graph) {
        int V = graph.length;
        List<Edge> edges = new ArrayList<>();

        // Convert graph to list of edges
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        // Sort edges based on their weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // Union-Find structure to detect cycles
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Kruskal's algorithm to construct MST
        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            int rootSrc = find(parent, edge.src);
            int rootDest = find(parent, edge.dest);

            // If the source and destination nodes are not in the same set, include this edge
            if (rootSrc != rootDest) {
                mst.add(edge);
                union(parent, rank, rootSrc, rootDest);
            }
        }

        // Print the edges of the MST
        System.out.println("Edges in the MST:");
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.src + " - " + edge.dest + " with weight: " + edge.weight);
        }
    }

    // Helper function to find the parent of a node
    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]); // Path compression
        }
        return parent[i];
    }

    // Helper function to perform union of two sets
    private static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 7, 0, 5, 0, 0},
                {7, 0, 8, 9, 7, 0},
                {0, 8, 0, 0, 5, 0},
                {5, 9, 0, 0, 15, 6},
                {0, 7, 5, 15, 0, 8},
                {0, 0, 0, 6, 8, 0}
        };

        kruskalMST(graph);
    }
}
