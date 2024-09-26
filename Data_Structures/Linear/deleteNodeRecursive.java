package com.Data_Structures_byprayush.Data_Structures.Linear;

import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class deleteNodeRecursive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split(" ");
        Node head = null;
        Node tail = null;
        for(int i = 0 ; i < s.length; i++){
            int current = Integer.parseInt(s[i]);//take the current element -> int
            if(current == -1)
                break;
            Node newNode = new Node(current);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        //take the index as input
        int idx = scan.nextInt();
        head = deleteNode(head,0, idx);
        printList(head);
    }

    public static Node deleteNode(Node temp, int idx, int target) {
        if(temp == null){
            return null;
        }
        if(idx == target){
            return temp.next;
        }
        temp.next = deleteNode(temp.next, idx+1, target);
        return temp;
    }

    public static void printList(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
