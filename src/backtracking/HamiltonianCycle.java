package graph;

import java.util.Arrays;

public class HamiltonianCycle {
    private int V; // Number of vertices
    private int[][] graph;
    private int[] path;

    public HamiltonianCycle(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.path = new int[V];
        Arrays.fill(path, -1);
    }

    public boolean isHamiltonianCycle() {
        path[0] = 0; // Start from first vertex
        return hamiltonianCycleUtil(1);
    }

    private boolean hamiltonianCycleUtil(int pos) {
        if (pos == V) {
            // If all vertices are included, check if there's an edge to start vertex
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;
                if (hamiltonianCycleUtil(pos + 1)) return true;
                path[pos] = -1; // Backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int v, int pos) {
        if (graph[path[pos - 1]][v] == 0) return false; // Not connected
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) return false; // Already visited
        }
        return true;
    }

    public void printSolution() {
        if (isHamiltonianCycle()) {
            System.out.println("Hamiltonian Cycle exists:");
            for (int vertex : path) System.out.print(vertex + " ");
            System.out.println(path[0]); // Closing the cycle
        } else {
            System.out.println("No Hamiltonian Cycle found.");
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };

        HamiltonianCycle hc = new HamiltonianCycle(graph);
        hc.printSolution();
    }
}
