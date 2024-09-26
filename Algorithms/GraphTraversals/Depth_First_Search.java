package com.Data_Structures_byprayush.Algorithms.GraphTraversals;

import java.util.List;


public class Depth_First_Search {
    public void dfs(List<List<Integer>> adj, boolean[] visited, int node){
        //most basic implementation of dfs
        visited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]) {
                dfs(adj, visited, neighbour);
            }
        }
    }
}
