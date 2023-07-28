package com.Data_Structures_byprayush.Data_Structures.Linear;

import java.util.LinkedList;
        import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Function to push an element onto the stack
    public void push(int value) {
        queue1.add(value);
    }

    // Function to pop the top element from the stack
    public int pop() {
        // Move all elements from queue1 to queue2 except the last one
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // Dequeue and return the last element from queue1 (which is the top element of the stack)
        int topElement = queue1.remove();

        // Swap the names of queue1 and queue2 for the next pop operation
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Function to check if the stack is empty
    public boolean empty() {
        return queue1.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        StackUsingQueues myStack = new StackUsingQueues();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop()); // Output: 3 (Last element pushed is the first to be popped)
        System.out.println(myStack.pop()); // Output: 2
        System.out.println(myStack.pop()); // Output: 1
        System.out.println(myStack.empty()); // Output: true

    }
}
