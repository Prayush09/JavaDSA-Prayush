package com.Data_Structures_byprayush.Algorithms.Recursion;
//creating a linked list to represent a line.
//So I did recursive solution to find the number of people in a line.
//I thought the best way to represent a line is ll so used that.
//In recursive function if the head == null -> line is empty
//=> Return 0.
//If not null then return the the same function but with a parameter of the next node.
//This will repeat until the base condition that is the if statement is reached.

import java.time.Period;

public class What_is_recursion {

    static Node head;
    int length = 0;

    public class Node{

        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    public void AddNewPerson(int new_data) {
        Node new_node = new Node(new_data);
        length++;
        if(head == null){
           head = new_node;
        }
        else{
            Node last = head;
            while(last.next != null)
                last = last.next;
            last.next = new_node;
        }
    }


    public static int nextPerson(Node person)
    {
        return nextPersonRecursive(person);
    }

    public static int nextPersonRecursive(Node person)
    {
        if(person == null)
            return 0;
        return 1 + nextPersonRecursive(person.next);
    }

    //to display the linked list.



    public static void main(String[] args)
    {
        What_is_recursion person= new What_is_recursion();


        person.AddNewPerson(1);
        person.AddNewPerson(2);
        person.AddNewPerson(3);
        person.AddNewPerson(4);
        person.AddNewPerson(5);
        person.AddNewPerson(6);
        person.AddNewPerson(7);
        person.AddNewPerson(8);

        int count = nextPerson(person.head);
        System.out.println("This is the total count of the line: "+count);
        System.out.println("This was implemented using a linked list and a recursive call.");

    }
}
