package com.Data_Structures_byprayush.Data_Structures.Non_Linear;

import java.util.*;

public class Root_To_Leaf {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
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

    static int rootToLeafSum(TreeNode root, String ans) {
        // If leaf node
        if (root.left == null && root.right == null) {
            ans = (ans == null ? "" : ans) + root.val;
            return Integer.parseInt(ans);
        }

        int l = 0, r = 0;
        if (root.left != null) {
            l = rootToLeafSum(root.left, (ans == null ? "" : ans) + root.val);
        }
        if (root.right != null) {
            r = rootToLeafSum(root.right, (ans == null ? "" : ans) + root.val);
        }

        return l + r;
    }

    public static int sumNumbers(TreeNode root) {
        return rootToLeafSum(root, null);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input to construct the binary tree
        String input = scanner.nextLine().trim();
        TreeNode root = buildTree(input);
        if(root == null)
            System.out.println(0);
            // Calculate the sum of root-to-leaf numbers
        else{
            int totalSum = sumNumbers(root);

            // Print the total sum
            System.out.println(totalSum);
        }
    }
}
