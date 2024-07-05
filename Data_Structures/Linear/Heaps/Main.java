package com.Data_Structures_byprayush.Data_Structures.Linear.Heaps;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> newHeap = new Heap<>();

        newHeap.insert(3);
        newHeap.insert(6);
        newHeap.insert(7);
        newHeap.insert(11);
        newHeap.insert(1);

        //implementing min Heap
        ArrayList list = newHeap.heapSort();
        System.out.println(list);
    }
}
