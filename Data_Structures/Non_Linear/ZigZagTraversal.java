package com.Data_Structures_byprayush.Data_Structures.Non_Linear;

import java.util.*;

public class ZigZagTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static ArrayList<ArrayList<Integer>> ZigZagTraverse(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();

        if (root == null)
            return ansList;

        // Keeping a flag:
        // odd levels -> flag == false -> right to left
        // even levels -> flag == true -> left to right
        // we keep this left to right and right to left,
        // by making the elements enter the front of the list for the odd case
        // and back of the list for the even case.
        nodeQueue.offer(root);
        boolean flag = true;
        while (!nodeQueue.isEmpty()) {
            int sizeLevel = nodeQueue.size();
            // Create a sublist, level-wise nodes will be stored in the list,
            // initialize it to the size of queue
            ArrayList<Integer> sublist = new ArrayList<>(sizeLevel);

            // Traverse the level
            for (int i = 0; i < sizeLevel; i++) {
                // For each index, check if the current node's left and right is null or not
                int index = i;
                // If not then add them to the queue
                if (nodeQueue.peek().left != null)
                    nodeQueue.offer(nodeQueue.peek().left);
                // Similarly
                if (nodeQueue.peek().right != null)
                    nodeQueue.offer(nodeQueue.peek().right);
                if (flag == true) {
                    sublist.add(nodeQueue.poll().data);
                } else {
                    sublist.add(0, nodeQueue.poll().data);
                }
            }
            // Switch the flag after one level traversal
            flag = !flag;
            ansList.add(sublist);
        }
        return ansList;
    }

    public static Node buildTree(String input) {
        if (input == null || input.isEmpty())
            return null;
        // Clear the white spaces between the nodes and separate the single characters
        String[] nodes = input.split("\\s+");
        Queue<Node> q = new LinkedList<>();
        // The first character in the string will be root
        Node root = new Node(Integer.parseInt(nodes[0]));
        // Add this root to the queue
        q.offer(root);

        // Traverse the whole nodes[] array
        for (int i = 1; i < nodes.length; i += 2) {
            // Get the current node from the queue
            Node current = q.poll();

            if (!nodes[i].equals("N")) {
                current.left = new Node(Integer.parseInt(nodes[i]));
                q.offer(current.left);
            }

            if (i + 1 < nodes.length && !nodes[i + 1].equals("N")) {
                current.right = new Node(Integer.parseInt(nodes[i + 1]));
                q.offer(current.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the nodes of the binary tree separated by spaces:");
        String s = scan.nextLine();

        Node tree = buildTree(s);
        ArrayList<ArrayList<Integer>> ans = ZigZagTraverse(tree);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
        }
    }
}
