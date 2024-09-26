package com.Data_Structures_byprayush.Data_Structures.Non_Linear;

public class AVL {

    public static class Node {
        private int height;
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
            this.height = 0;  // Initialize height as 0 for a new node
        }

        public int getValue() {
            return value;
        }
    }

    public Node root;

    public AVL() {
        // empty constructor
    }

    public int height(Node node) {
        if (node == null)
            return -1;  // Return -1 for null to handle height calculation correctly
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node root, String description) {
        if (root == null) {
            return;
        }
        System.out.println(description + " " + root.getValue());
        if (root.left != null) {
            System.out.print("  ");  // Indent for left child
            display(root.left, "Left Child of : " + root.getValue());
        }
        if (root.right != null) {
            System.out.print("  ");  // Indent for right child
            display(root.right, "Right Child of : " + root.getValue());
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.getValue()) {
            root.left = insert(root.left, value);
        } else if (value > root.getValue()) {
            root.right = insert(root.right, value);
        } else { // If the value is already present, we don't insert it again
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return rotate(root);
    }



    private Node rotate(Node root){
        //left heavy
        if(height(root.left)-height(root.right)>1){
            //left-left case : the height of the tree on the left of the child is greater than the height of the tree on the right of the child (P->C->G)

            if(height(root.left.left) - height(root.left.right)>0){

                return rightRotate(root);
            }

            //left-right case : the height of the tree on the right of the child is greater than the height of the tree on the left of the child (P->C->G)
            if(height(root.left.right)-height(root.left.left)>0){
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }else
        if(height(root.right)-height(root.left)>1){
            //right heavy
            if(height(root.right.right)-height(root.right.left)>0){
                //right-right case
                return leftRotate(root);
            }

            if(height(root.right.left)-height(root.right.right)>0){
                //right-left case
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left),height(p.right)+1);
        c.height = Math.max(height(c.left),height(c.right)+1);

        return c;
    }

    private Node leftRotate(Node p){
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left),height(p.right)+1);
        c.height = Math.max(height(c.left),height(c.right)+1);

        return c;

    }


    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node root) {
        if (root == null)
            return true;
        int leftHeight = root.left != null ? root.left.height : -1;
        int rightHeight = root.right != null ? root.right.height : -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;
        return balanced(root.left) && balanced(root.right);
    }

    public void populate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public void populateSorted(int[] arr){
        populateSorted(arr, 0, arr.length - 1);
    }

    private void populateSorted(int[] arr, int start, int end){
        if(start>=end)
            return;
        int mid = (start+end)/2;
        this.insert(arr[mid]);
        populateSorted(arr, start, mid);
        populateSorted(arr,mid+1,end);
    }


    public static void main(String[] args) {
        AVL bst = new AVL();
        int[] arr = new int[1001];
        for(int i = 0 ; i < 1000;i++){
            arr[i] = i+1;
        }
        bst.populateSorted(arr);
        bst.display();
        System.out.println("Is BST Balanced: " + bst.balanced());
    }

}
