package com.Data_Structures_byprayush.Data_Structures.Linear;

import java.io.*;
import java.util.*;

public class CyclicHareAndTurtoise{

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int cyclic(Node head) {
        if (head == null) return 0;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return 1;
            }
        }

        return 0;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] elements = scan.nextLine().split(" ");
        Node head = null;
        Node tail = null;
        Map<Integer, Node> nodeMap = new HashMap<>();

        for (String element : elements) {
            int data = Integer.parseInt(element);
            if (data == -1) break;
            Node newNode = new Node(data);
            nodeMap.put(data, newNode);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }


        int cycleStart = scan.nextInt(); // Read the position where the cycle starts (0 if no cycle)
        scan.close();

        if (cycleStart != -1 && nodeMap.containsKey(cycleStart)) {
            tail.next = nodeMap.get(cycleStart); // Create the cycle
        }

        int result = cyclic(head);
        System.out.print(result);
    }
}
