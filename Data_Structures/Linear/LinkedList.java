package com.Data_Structures_byprayush.Data_Structures.Linear;// Linked list operations in Java
//Prayush Giri
//21BCE7864

public class LinkedList {
    static Node head;


    // Create a node
    class Node {
        int data;
        Node next;
        /*
        How does next work?
        well imagine all the nodes are basically a hashmap
        so it will have
        {
        "data" = 10(say);
        "next" = {
                    "data" = 9;
                    "next" = null;
                 }
        }
        the above representation can be visulized like node(10)->node(9)
         */

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Insert at the beginning
    public void insertAtBeginning(int new_data) {
        // insert the data
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Insert after a node
    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    // Insert at the end
    public void insertAtEnd(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return;
    }

    // Delete a node
    void deleteNode(int position) {
        if (head == null)
            return;

        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }
        // Find the key to be deleted
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        // If the key is not present
        if (temp == null || temp.next == null)
            return;

        // Remove the node
        Node next = temp.next.next;

        temp.next = next;
    }

    // Search a node
    boolean search(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key)
                return true;
            current = current.next;
        }
        return false;
    }

    // Sort the linked list
    void sortLinkedList(Node head) {
        Node current = head;
        Node index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // index points to the node next to current
                index = current.next;

                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    Node reverseLinkedList(Node node) {
        Node next;
        Node current = node;
        Node prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }


    // Print the linked list
    public void printList() {
        Node display_pointer = head;
        while (display_pointer != null) {
            System.out.print(display_pointer.data + " ");
            display_pointer = display_pointer.next;
        }

    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

        public static void main(String [] args)
        {
            LinkedList llist = new LinkedList();


            llist.insertAtBeginning(4);

            llist.insertAtBeginning(3);
            llist.insertAtEnd(4);
            llist.insertAfter(llist.head.next, 5);

            System.out.println("Linked list: ");
            llist.printList(head);

//            System.out.println("\nAfter deleting an element: ");
//            llist.deleteNode(3);
//            llist.printList();

            head = llist.reverseLinkedList(head);
            System.out.println("\nReversing the linked list");
            llist.printList(head);

            System.out.println();
            int item_to_find = 3;
            System.out.println("Searching for Item: " + item_to_find);
            if (llist.search(llist.head, item_to_find))
                System.out.println(item_to_find + " is found");
            else
                System.out.println(item_to_find + " is not found");

            llist.sortLinkedList(llist.head);
            System.out.println("\nSorted List: ");
            llist.printList();

        }

}