package com.Data_Structures_byprayush.Algorithms.Recursion;

public class LinkedListReversal{

    public static void main(String[] args)
    {
        Node f1 = new Node(1);
        Node f2 = new Node(2);
        Node f3 = new Node(3);
        Node f4 = new Node(4);
        Node f5 = new Node(5);
        Node f6 = new Node(6);
        Node f7 = new Node(7);

        f1.setNext(f2);
        f2.setNext(f3);
        f3.setNext(f4);
        f4.setNext(f5);
        f5.setNext(f6);
        f6.setNext(f7);

        printLinkedList(f1);
        Node reversed = reverseLinkedList(f1);
        System.out.println("");
        printLinkedList(reversed);
    }

    static class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }

        public void setNext(Node node){
            this.next = node;
        }

        public Node getNext(){
            return next;
        }
    }

    public static void printLinkedList(Node node){
        Node temp = node;
        while(temp != null)
        {
            System.out.print(temp.val+" ");
            temp = temp.getNext();
        }
    }

    public static Node reverseLinkedList(Node node)
    {
        //base case
        if(node == null || node.next == null)
            return node;
        Node reverse = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return reverse;
    }
}
