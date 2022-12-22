package com.Data_Structures_byprayush.problems.Assignments;
//aadhar number: 619502967595
public class Doubly_Linked_list {
    Node head;
    class Node{
        int data;
        Node prev;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }
    //Here push method will only take BIG O(1) Time complexity
    public void push(int new_data)
    {
        //allocating node and putting data in it.
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        new_Node.prev = null;
        if(head != null)
            head.prev = new_Node;
        head = new_Node;
    }
    //printList Method will take BIG O(n) Time complexity as we are going through the whole DLL.
    public void printList(Node node)
    {
        Node last = null;
        System.out.println("Traversing from the front: ");
        while(node != null)
        {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversing from the rear: ");
        while(last!=null)
        {
            System.out.print(last.data+" ");
            last = last.prev;
        }
    }

    public static void main(String [] args)
    {
        //My aadhar : 6195 0296 7595
        doublyLinkedList OBJ = new doublyLinkedList();
        OBJ.push(6);
        OBJ.push(1);
        OBJ.push(9);
        OBJ.push(5);
        OBJ.push(0);
        OBJ.push(2);
        OBJ.push(9);
        OBJ.push(6);
        OBJ.push(7);
        OBJ.push(5);
        OBJ.push(9);
        OBJ.push(5);
        OBJ.printList(OBJ.head);
    }
}
