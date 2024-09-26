package com.Data_Structures_byprayush.Algorithms.GraphTraversals;
import java.util.*;
public class PrimsAlgorithm {
    //prims algorithm is used to find the MST of a tree
    //-> MST : Minimum Spanning Tree : Tells the shortest and cheapest path available from one node to another.
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];  // Store parents of nodes in the MST
        Arrays.fill(parent, -1);    // Initialize parent array with -1

        pq.add(new int[]{0, 0});  // {weight, node}

        int sum = 0;

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int node = p[1];
            int wt = p[0];

            if (visited[node]) continue;

            visited[node] = true;
            sum += wt;

            for (List<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edgeWt = it.get(1);

                if (!visited[adjNode]) {
                    pq.add(new int[]{edgeWt, adjNode});
                    parent[adjNode] = node;  // Set parent of adjNode
                }
            }
        }

        // Printing the path from node 0 to each node in MST
        for (int i = 1; i < V; i++) {
            if(i == V-1)
                System.out.print("Path to node "+ i + " (MST) : ");
            else
                System.out.print("Path to node " + i + ": ");
            printPath(i, parent);
            System.out.println();
        }

        return sum;
    }

    private void printPath(int node, int[] parent) {
        if (node == -1) return;
        printPath(parent[node], parent);
        System.out.print(node + " ");
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(1, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(0, 3, 4)
        );

        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            adj.get(u).add(Arrays.asList(v, wt));
            adj.get(v).add(Arrays.asList(u, wt));
        }

        PrimsAlgorithm sol = new PrimsAlgorithm();
        int ans = sol.spanningTree(V, adj);
        System.out.println("The sum of weights of edges in MST is: " + ans);
    }

}
