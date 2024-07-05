package com.Data_Structures_byprayush.Data_Structures.Linear.Stacks;

public class Custom_Stack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int pointer = -1;

    public Custom_Stack(){
        this(DEFAULT_SIZE);
    }

    public Custom_Stack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        pointer++;
        data[pointer] = item;
        return true;
    }

    public int remove() throws StackException{
        if(isEmpty())
        {
             throw new StackException("Cannot pop from empty stack");
        }
        int removed = data[pointer--];
        return removed;
    }

    public int peek() throws StackException {
        if(isEmpty())
        {
            throw new StackException("Cannot peek from empty stack");
        }
        return data[pointer];
    }

    public boolean isFull() {
        return pointer == data.length-1;
    }

    public boolean isEmpty(){
        return pointer == -1;
    }
}
