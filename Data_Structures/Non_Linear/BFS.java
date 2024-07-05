package com.Data_Structures_byprayush.Data_Structures.Non_Linear;

import java.util.*;

public class BFS {
    private int V; // Number of vertices
    private ArrayList<ArrayList<Integer>> adj; // Adjacency list representation of the graph

    // Constructor
    public BFS(int v) {
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    // Function to add an edge to the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // Function to perform Breadth First Search traversal starting from source s
    void BFS(int s) {
        // Mark all the vertices as not visited (by default set to false)
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s. If an adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int j : adj.get(s)) {
                if (!visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    // Driver method to test BFS traversal
    public static void main(String args[]) {
        BFS g = new BFS(4); // Create a graph with 4 vertices
        g.addEdge(0, 1); // Add edges to the graph
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        g.BFS(2); // Perform BFS traversal starting from vertex 2
    }
}
