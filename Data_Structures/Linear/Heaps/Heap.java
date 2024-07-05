package com.Data_Structures_byprayush.Data_Structures.Linear.Heaps;
import java.util.ArrayList;
public class Heap<T extends Comparable<T>>{
    private ArrayList<T> list;
    //creating a heap data structure using arraylist.
    //using Comparable T -> Type, this will put the type defined by the user at the time of execution.
    public Heap(){
        list = new ArrayList<>();
    }

   private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
   }

   private int parentIndex(int index){
        return (index-1)/2;
   }

   private int leftChild(int index){
        return (index*2 + 1);
   }

   private int rightChild(int index){
        return (index*2 + 2);
   }

   public void insert(T value){
        list.add(value);
        upheap(list.size()-1);//we uphead from the last index to the root index
   }

   private void upheap(int index){
        if(index == 0)
            return;
        //we need the parent's index of the current node
       int parentIndex = parentIndex(index);
       //find if the parent is smaller than child or not? compareTo return < 0 if child is smaller
       // > 0 if child is greater and == 0 if they are the same.
       if(list.get(index).compareTo(list.get(parentIndex)) < 0){
           swap(index, parentIndex);
           upheap(parentIndex);//after swapping check the parent index to go up recursively untill root
       }
   }

   public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap");
        }
        T temp = list.get(0);// removing the last element and then returning it back using temp.

        T last = list.remove(list.size()-1);//removing the last element;

       if(!list.isEmpty()){
           list.set(0,last); //settting the last removed element as root, then applying down heap
           downheap(0);
       }
       return temp;
   }

   private void downheap(int index){
        int min = index;
        int right = rightChild(index);
        int left = leftChild(index);

        if(left<list.size() && list.get(min).compareTo(list.get(left))>0)
            min = left;
        if(right < list.size() && list.get(min).compareTo(list.get(right))>0)
            min = right;
        if(min != index){
            swap(min,index);
            downheap(min);
        }
   }

   public ArrayList heapSort() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Heap is empty!");
        }
        ArrayList<T> SortedOrder = new ArrayList<>();
        while(!list.isEmpty()){
            SortedOrder.add(this.remove());
        }
        return SortedOrder;
   }
}
