package com.Data_Structures_byprayush.Algorithms.Recursion;

public class MergeSort_LinkedList {
    static class Node{
        private int val;
        private Node next;

        public  Node(int val)
        {
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }
    }

    public static Node mergeSort(Node A, Node B)
    {
        //base cases:
        if(A == null)
            return B;
        if(B == null)
            return A;

        //recursion on the two lists:
        if(A.val < B.val){
            A.next = mergeSort(A.next,B);
            return A;
        }else{
            B.next = mergeSort(A,B.next);
            return B;
        }
    }

    public static void print_list(Node node){
        Node temp = node;
        while(temp != null)
        {
            System.out.print(temp.getVal()+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {
        Node l1 = new Node(1);
        Node l2 = new Node(5);
        Node l3 = new Node(15);
        Node l4 = new Node(30);
        Node l5 = new Node(50);

        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);

        Node ll1 = new Node(2);
        Node ll2 = new Node(12);
        Node ll3 = new Node(22);
        Node ll4 = new Node(32);
        Node ll5 = new Node(42);

        ll1.setNext(ll2);
        ll2.setNext(ll3);
        ll3.setNext(ll4);
        ll4.setNext(ll5);

        print_list(l1);
        System.out.println("");
        print_list(ll1);
        System.out.println("");
        Node SortedMerge = mergeSort(l1,ll1);
        print_list(SortedMerge);
    }
}
