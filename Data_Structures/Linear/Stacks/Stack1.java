package com.Data_Structures_byprayush.Data_Structures.Linear.Stacks;

import java.util.Scanner;

public class Stack1{
    private int top;
    private int maxsize = 10;
    private int[] arr = new int[maxsize];

    public boolean isEmpty()
    {
       return top<0;
    }
    public Stack1()
    {
        top = -1;
    }
//You can take Scanner object as parameter within a function so that you just have to
// initialize a Scanner once and you can input values using that particular scanner
// object by passing it to various method's parameters.
public boolean push(Scanner scan)
    {
        if(top>=maxsize-1)
        {
            System.out.println("Overflow");
            return false;
        }
        else{
            top++;
            arr[top]=scan.nextInt();
            System.out.println("Item pushed!");
            return true;

        }
    }

    public boolean pop(){
        if(top == -1)
        {
            System.out.println("Stack is empty!");
            return false;
        }
        else{
            top--;
            System.out.println();
            return true;
        }
    }

    public void display(){
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        System.out.println("-------Stack Operations-------");
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        Stack1 sc = new Stack1();
        while(choice!=4)
        {
            System.out.println("Enter your choice: ");
            System.out.println(" 0.isEmpty\n 1.Push\n 2.Pop\n 3.Display\n 4.Exit");
            choice = scan.nextInt();
            switch(choice){
               case 0 -> System.out.println(sc.isEmpty());
               case 1 -> sc.push(scan);
               case 2 -> sc.pop();
               case 3 -> sc.display();
               case 4 -> {
                   System.out.println("Exiting...");
                   System.exit(0);
               }
        }
        }
    }
}