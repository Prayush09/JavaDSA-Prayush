package com.Data_Structures_byprayush.problems.Assignments;
import java.util.Scanner;

class Stack {
        int top;
        int maxsize = 10;
        int[] arr = new int[maxsize];


        boolean isEmpty() {
            return (top < 0);
        }

        Stack() {

            top = -1;
        }

        boolean push(int a) {
            if (top == maxsize - 1) {
                System.out.println("Overflow !!");
                return false;
            } else {
                top++;
                arr[top] = a;
                return true;
            }
        }

        boolean pop() {
            if (top == -1) {
                System.out.println("Underflow !!");
                return false;
            } else {
                top--;
                System.out.println("Item popped");
                return true;
            }
        }

        void display() {
            System.out.println("Printing stack elements .....");
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
class QNode {
    Object key;
    QNode next;

    // constructor to create a new linked list node
    public QNode(Object key)
    {
        this.key = key;
        this.next = null;
    }
}
class Queue_Operations{
    QNode front, rear;

    public Queue_Operations()
    {
        this.front = this.rear = null;
    }

    // Method to add an key to the queue.
    void enqueue(Object key)
    {

        // Create a new LL node
        QNode temp = new QNode(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    void dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;

        // Store previous front and move front one node ahead
        QNode temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
    }
    void print()
    {
        do{
            System.out.println(front.key);
            front = front.next;
        } while(front.next != null);

    }
}
class LinkedList{
    Node head;
    class Node{
        Object data;
        Node next;
        Node(Object data)
        {
            this.data = data;
            next = null;
        }
    }
    void InsertAtBeginning(Object data)
    {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }
    void printlist(){
        Node temp=head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
class doublyLinkedList {
    Node head;

    static class Node {
        Object data;
        Node prev;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

    //Here push method will only take BIG O(1) Time complexity
    public void push(Object new_data) {
        //allocating node and putting data in it.
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        new_Node.prev = null;
        if (head != null)
            head.prev = new_Node;
        head = new_Node;
    }

    //printList Method will take BIG O(n) Time complexity as we are going through the whole DLL.
    public void printList(Node node) {
        Node last = null;
        while (node != null) {
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("DOUBLY LINKED LIST:  ");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }
}
    class Operations {
        public static void main(String[] args) {
            int choice = 0;
            Scanner sc = new Scanner(System.in);
            Stack s = new Stack();
            System.out.println("*********Stack operations using array*********\n");
            System.out.println("\n------------------------------------------------\n");
            s.push(7);
            s.push(8);
            s.push(6);
            s.push(4);
            s.display();
            System.out.println("\n------------------------------------------------\n");
            System.out.println("NOW WE ENTER A DOUBLY LINKED LIST: ");
            doublyLinkedList DLL = new doublyLinkedList();
            DLL.push(2);
            DLL.push(1);
            DLL.push("B");
            DLL.push("C");
            DLL.push("E");
            DLL.push(7);
            DLL.push(8);
            DLL.push(6);
            DLL.push(4);
            DLL.printList(DLL.head);
            System.out.println("\n------------------------------------------------\n");
            System.out.println("NOW WE SEE QUEUE IMPLEMENTATION: ");
            Queue_Operations q = new Queue_Operations();
            q.enqueue(21);
            q.enqueue("BCE");
            q.enqueue(7864);
            q.enqueue(0);
            q.print();
            System.out.println("\n------------------------------------------------\n");
            System.out.println("Here we see Linked List Implementation: ");
            LinkedList ll = new LinkedList();
            ll.InsertAtBeginning(7864);
            ll.InsertAtBeginning("BCE");
            ll.InsertAtBeginning(21);
            ll.printlist();
            System.out.println("\n------------------------------------------------\n");
        }
    }


