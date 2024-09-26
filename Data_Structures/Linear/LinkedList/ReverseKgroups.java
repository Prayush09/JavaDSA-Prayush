package com.Data_Structures_byprayush.Data_Structures.Linear.LinkedList;

import java.util.Scanner;

class ReverseKgroups {
    Node head; // head of list

    /* Linked list Node */
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to reverse every k nodes in the linked list
    Node reverse(Node head, int k, int size) {
        if (head == null || size < k)
            return head; // No need to reverse if list is empty or size < k

        Node current = head;
        Node next = null;
        Node prev = null;
        Node newHead = null;

        int count = 0;

        // Reverse first k nodes of linked list
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // If new_head is not set, then the first group is reversed
        if (newHead == null)
            newHead = prev;

        // Connect with the next part of the list
        if (next != null)
            head.next = reverse(next, k, size - k);

        return newHead;
    }

    /* Utility functions */

    // Inserts a new Node at the end of the list
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

    // Function to print linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Function to return the size of the linked list
    int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ReverseKgroups llist = new ReverseKgroups();
        Scanner scan = new Scanner(System.in);

        // Read linked list values
        while (true) {
            int val = scan.nextInt();
            if (val == -1) break;
            llist.append(val);
        }

        // Get size of the list
        int size = llist.size();

        // Read k and reverse the list in groups of k
        int k = scan.nextInt();
        llist.head = llist.reverse(llist.head, k, size);

        // Print the reversed list
        llist.printList();

        scan.close();
    }
}
