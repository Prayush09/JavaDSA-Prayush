package com.Data_Structures_byprayush.Data_Structures.Linear.Queue;

public class CircularQueue{
    public int[] data;
    protected int front = 0;
    protected int end = 0;
    private int size = 0;

    private static final int DEFAULT_SIZE = 10;


    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size){
        this.data = new int[size];
    }


    public boolean isFull(){
        return size == data.length; //pointer is at last idx
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean insert(int item){
        if(isFull())
            return false;
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }


    public int remove() throws Exception{
        if (isEmpty())
            throw new Exception("Circular Queue is empty");
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }
    //this display() works because it takes a third pointer, i
    //which first prints the front element then increases by 1,
    //checks if its not at the last index, and then checks
    //if it has not reached the end.
    public void display(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i]+"<-");
            i++;
            i %= data.length;
        }while(i != end);
        System.out.println("END");
    }
    //this does not work because:
    //  -> the front and end pointer are at the same index
    // -> this terminates the for loop
    // -> if and only if they are not at the same index
    //      -> then only the for loop executes
//    public void display(){
//        for (int i = front; i != end; i++) {
//            i %= data.length;
//            System.out.print(data[i]+"<-");
//        }
//        System.out.println("END");
//    }
}
