package com.Data_Structures_byprayush.Data_Structures.Linear;


public class DoublyLinkedList {
    //What pointers a node will represent.
    private Node head;
    private Node tail;
    private int length;

    //A class for Node Blueprint
    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    //Node creation
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    //Function to display the DLL.
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head : "+head.value);
    }

    public void getTail(){
        System.out.println("Tail : "+tail.value);
    }

    public void getLength(){
        System.out.println("Length : "+length);
    }

    //Append method to add an element at the end
    public void append(int value)
    {
        Node newNode = new Node(value);
        //If we have 0 items in linked list
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    public Node removeLast()
    {
        //If there is no element in the linked list(doubly)
        if(length == 0)
            return null;
        Node temp = tail;
        //If there is only one node in the linked list(doubly)
       if(length == 1)
       {
           head = null;
           tail = null;
       }
       else
       {
           tail = tail.prev;
           tail.next = null;
           temp.prev = null;
       }
       length--;
       return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0)
        {
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node get(int index)
    {
        if(index < 0 || index >= length) return null;
        Node temp = head;
        if(index < length/2)
            for(int i = 0; i < index ; i++)
                temp = temp.next;
        else{
            temp = tail;
            for (int i = length-1; i > index ; i--)
                temp = temp.prev;
        }
        return temp;
    }

    public Node removeFirst()
    {
        if(length == 0)
            return null;
        Node temp = head;
        if(length == 1)
        {
            head = null;
            tail = null;
        }

        else{
            head = head.next;
            head.prev = null;
            temp.next = null;
            }
        length--;
        return temp;
    }

    public boolean set(int index, int value)
    {
        Node temp = get(index);
        if(temp != null)
        {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value)
    {
        if(index < 0 || index > length)
            return false;
        if(index == 0)
        {
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index-1);
        Node after = before.next;
        //Interchanging the connection between nodes.
        newNode.prev = before;
        before.next = newNode;
        newNode.next = after;
        after.prev = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0)
            return removeFirst();
        if(index == length-1)
            return removeLast();
        Node temp = get(index);
        /*
        Another way is before and after
        temp.prev = before;
        temp.next = after;
        before.next = after;
        after.prev = before;
        temp.next = null;
        temp.prev = null;
         */
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }
    public static void main(String [] args)
    {
        //Creating a DLL
        DoublyLinkedList myDLL = new DoublyLinkedList(8);
        myDLL.append(10);
        myDLL.printList();
        myDLL.removeLast();
        System.out.println();
        myDLL.printList();
        System.out.println();
        myDLL.prepend(75);
        myDLL.prepend(92);
        myDLL.printList();
        System.out.println();
        myDLL.removeFirst();
        myDLL.printList();
        myDLL.append(5);
        myDLL.append(38);
        myDLL.append(72);
        myDLL.append(89);
        System.out.println();
        myDLL.printList();
        System.out.println();
        System.out.println(myDLL.get(4).value);
        myDLL.set(4,4);
        System.out.println();
        myDLL.printList();
        myDLL.insert(3,7864);
        System.out.println();
        myDLL.printList();
        System.out.println();
        myDLL.remove(2);
        System.out.println();
        myDLL.printList();
    }
}
