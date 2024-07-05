package com.Data_Structures_byprayush.Algorithms.Recursion;

public class Depth_First_Search {
    //visited is used to keep count of visited nodes
    // as graphs can have cycles, we do not want to visit a node more than once.

    /*
    boolean depthFirstSearch(Node node, Set<Node> visited, int goal)
    {
        if(node == null)
            return false;
        if(node.val == goal)
            return true;

        for(Node neighbor : node.getNeighbors())
        {
            if(visited.contains(neighbor)) continue;
            visited.add(neighbor);
            boolean isFound = depthFirstSearch(neighbor,visited, goal);

            if(isFound)
                return true;
        }
        return false;
    }

     */
}
