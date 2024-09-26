package com.Data_Structures_byprayush.Algorithms.GraphTraversals;

public class BST {
    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Node root;

    public BST(){

    }

    public int height(Node node){
        if(node == null)
            return -1;
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node == null)
            return;
        System.out.println(details + node.getValue());

        display(node.left, "Left child of "+node.getValue()+" : ");
        display(node.right, "Right child of "+ node.getValue()+" : ");
    }

    public void insert(int value){
        root = insert(root,value);
    }

    private Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        if(node.getValue() > value){
            node.left = insert(node.left,value);
        }
        if(node.getValue() < value){
            node.right = insert(node.right, value);
        }

        //update the height of the tree
        node.height = Math.max(height(node.left),height(node.right))+1;

        //we want to make sure the remaining links remain the same
        return node;
    }

    public void insert(int[] nums){
        for(int i = 0; i < nums.length; i++){
            this.insert(nums[i]);
        }
    }

    public void insertSorted(int[] nums){
        insertSorted(nums,0,nums.length-1);
    }

    private void insertSorted(int[] nums,int start, int end){
        if(start>=end)
            return;
        int middle = (start+end)/2;
        insert(nums[middle]);
        insertSorted(nums,start,middle);
        insertSorted(nums,middle+1,end);
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null)
            return true;
        return (Math.abs(height(node.left) - height(node.right)) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right));
    }

    public static void main(String[] args){
       BST tree = new BST();
       int[] arr = {1,2,3,4,5,6,7,8,9,10};
       tree.insertSorted(arr);
       tree.display();
    }


}
