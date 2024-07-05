package com.Data_Structures_byprayush.Data_Structures.Linear.Queue;

public class CustomQueue {
    private int[] data;
     private static final int DEFAULT_SIZE = 10;

     int end = 0;

     public CustomQueue() {
         this(DEFAULT_SIZE);
     }

     public CustomQueue(int size){
         this.data = new int[size];
     }

     public boolean isEmpty(){
         return end == 0;
     }

     public boolean isFull(){
         return end == data.length;
     }

     //O(1)
     public boolean insert(int item){
         if(isFull())
             return false;
         data[end++] = item;
         return true;
     }

     //O(n)
     public int remove() throws Exception{
         if(isEmpty())
             throw new Exception("Queue is empty");
         int removed = data[0];
         //shift all the elements to the left side
         for(int i = 1; i < end;i++){
             data[i-1] = data[i];
         }
         end--;//keeping track of the current elements in the queue.
         return removed;
     }

     public int peek() throws Exception{
         if(isEmpty())
             throw new Exception("Queue is empty");
         return data[0];
     }

     public void display(){
         for (int i = 0; i < end; i++) {
             System.out.print(data[i]+"<-");
         }
         System.out.println("END");
     }
}
