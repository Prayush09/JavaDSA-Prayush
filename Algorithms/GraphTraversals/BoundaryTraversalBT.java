package com.Data_Structures_byprayush.Algorithms.GraphTraversals;

import java.util.*;

class BoundaryOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    //pre order
    public void leftBoundary(TreeNode node, List<Integer> res) {
        if (node == null || (node.left == null && node.right == null))
            return;
        res.add(node.val);
        if (node.left != null)
            leftBoundary(node.left, res);
        else
            leftBoundary(node.right, res);
    }
    //post order
    public void rightBoundary(TreeNode node, List<Integer> res) {

        if (node == null || (node.left == null && node.right == null))
            return;
        if (node.right != null)
            rightBoundary(node.right, res);
        else
            rightBoundary(node.left, res);
        res.add(node.val);
    }
    //pre order
    public void leaves(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        leaves(node.left, res);
        leaves(node.right, res);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);  // Add root node
        leftBoundary(root.left, res);
        leaves(root.left, res);
        leaves(root.right,res);
        rightBoundary(root.right, res);
        return res;
    }

    public static void main(String[] args) {
        // Create test cases to test boundaryOfBinaryTree
        BoundaryOfBinaryTree tree = new BoundaryOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        List<Integer> boundary = tree.boundaryOfBinaryTree(root);
        System.out.println("Boundary of the binary tree is: " + boundary);
    }
}
