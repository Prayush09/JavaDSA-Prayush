package com.Data_Structures_byprayush;

public class Singly_Linked_List {
    Node head;
    Node prev;
    class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
}
