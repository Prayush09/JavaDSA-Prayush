package com.Data_Structures_byprayush.Data_Structures.Non_Linear;
import java.util.*;
public class Prims_Algo {
    class Main{
        static class Edge{
            int vertex;
            int weight;
            Edge(int vertex , int weight){
                this.vertex = vertex;
                this.weight = weight;
            }
        }
        static void addEdge(List<Edge>[] adjust , int u , int v , int weight){
            adjust[u].add(new Edge(v , weight));
            adjust[v].add(new Edge(u , weight));
        }
        static void printGraph(List<Edge>[] adjList){
            for(int i = 0; i < adjList.length ; i++){
                System.out.print(i + " : ");
                for(Edge neighbor : adjList[i]){
                    System.out.print("(" + neighbor.vertex + " , " + neighbor.weight + ")");
                }
                System.out.println();
            }
        }
        static class PrimResult{
            List<Edge> mst;
            int totalWeight;
            PrimResult(List<Edge> mst , int totalWeight){
                this.mst = mst;
                this.totalWeight = totalWeight;
            }
        }
        static PrimResult prims(List<Edge>[] adjList , int start){
            Set<Integer> visited = new HashSet<>();
            List<Edge> mst = new ArrayList<>();
            int totalWeight = 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            pq.offer(new Edge(start , 0));
            while(!pq.isEmpty() && visited.size() < adjList.length){
                Edge minEdge = pq.poll();
                int vertex = minEdge.vertex;
                int weight = minEdge.weight;
                if(!visited.contains(vertex)){
                    mst.add(minEdge);
                    visited.add(vertex);
                    totalWeight += weight;
                    for(Edge neighbor : adjList[vertex]){
                        if(!visited.contains(neighbor.vertex)){
                            pq.offer(neighbor);
                        }
                    }
                }
            }
            return new PrimResult(mst , totalWeight);
        }
        public static void main(String [] args){
            Scanner scanner = new Scanner(System.in);
            int vertices = scanner.nextInt();
            int edges = scanner.nextInt();
            List<Edge>[] adjList = new List[vertices];
            for(int i = 0; i < vertices ; i++){
                adjList[i] = new ArrayList<>();
            }
            for(int i = 0 ; i < edges ; i++){
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int weight = scanner.nextInt();
                addEdge(adjList , u , v , weight);
            }
            PrimResult result = prims(adjList , 0);
            System.out.println(result.totalWeight);
        }
    }
}
