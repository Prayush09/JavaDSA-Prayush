package com.Data_Structures_byprayush.Data_Structures.Non_Linear;

import java.util.*;

public class RightViewTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input to construct the binary tree
        String input = scanner.nextLine().trim();
        TreeNode root = buildTree(input);

        // Finding the right view of the binary tree
        List<Integer> rightView = rightSideView(root);

        // Printing the right view
        for (int i = 0; i < rightView.size(); i++) {
            System.out.print(rightView.get(i));
            if (i < rightView.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static TreeNode buildTree(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] nodes = input.split("\\s+");
        if (nodes[0].equals("N")) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode current = queue.poll();

            if (!nodes[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(current.left);
            }

            if (i + 1 < nodes.length && !nodes[i + 1].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                queue.offer(current.right);
            }
        }

        return root;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public static void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        // Traverse right first to ensure the rightmost node is visited first at each level
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }
}
