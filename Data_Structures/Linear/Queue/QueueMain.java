package com.Data_Structures_byprayush.Data_Structures.Linear.Queue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);
//        queue.insert(10);
//        queue.insert(20);
//        queue.insert(30);
//        queue.insert(40);
//        queue.insert(50);
//        queue.display();
//        System.out.println(queue.remove());
//        queue.display();

        CircularQueue q = new CircularQueue(5);
        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.insert(50);
        q.insert(5);
        q.display();
        q.remove();
        q.remove();
        q.insert(3);
        q.display();
    }
}
