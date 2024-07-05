package com.Data_Structures_byprayush.Data_Structures.Linear.Stacks;

public class Main_ForStack {

    public static void main(String[] args) throws StackException {
        Custom_Stack stack1 = new DynamicStack(5);
        stack1.push(10);
        stack1.push(5);
        stack1.push(3);
        stack1.push(25);
        stack1.push(89);
        stack1.push(100);
        System.out.println(stack1.remove());
        System.out.println(stack1.remove());
        System.out.println(stack1.remove());
        System.out.println(stack1.remove());
        System.out.println(stack1.remove());
        System.out.println(stack1.peek());
    }

}