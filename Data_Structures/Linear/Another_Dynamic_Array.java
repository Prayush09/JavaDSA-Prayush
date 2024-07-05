package com.Data_Structures_byprayush.Data_Structures.Linear;

@SuppressWarnings("unchecked")
public class Another_Dynamic_Array<P> implements Iterable<P>{
            private P[] array;
            private int size;//length user thinks array is
            private int capacity = 0; //Actual array size.
     public Another_Dynamic_Array(){
         this(16);
     }

    public Another_Dynamic_Array(int capacity) {
         if(capacity < 0) throw new IllegalArgumentException("Illegal Argument");
         this.capacity = capacity;
         array = (P[]) new Object[capacity];
    }
    //Now create a bunch of function for the array.

    public int size(){
         return size;
    }

    public boolean isEmpty(){
         return size == 0;
    }

    public P get (int index) {
        return array[index];
    }

    public void set(int index, P element){
         array[index] = element;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public void add(P element){
         if(size >= capacity){
             if(capacity == 0)
                 capacity = 1;
             else
                 capacity = capacity * 2;
             P[] new_array = (P[]) new Object[capacity];//making a new array.
             for (int i = 0; i < size; i++) {
                 new_array[i] = array[i];
             }
             array = new_array;//Assigning the values of the new_array to array, now array has extra nulls padded.
         }
         array[size++] = element;
    }

    // Removes an element at the specified index in this array.
    public P removeAt(int index) {
        if (index >= index || index < 0) throw new IndexOutOfBoundsException();
        P data = array[index];
        P[] new_array = (P[]) new Object[index - 1];

        for (int i = 0, j = 0; i < index; i++, j++)
            if (i == index) j--; // Skip over index by fixing j temporarily
            else new_array[j] = array[i];
        array = new_array;
        capacity = --index;
        return data;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj == null) {
                if (array[i] == null) return i;
            } else {
                if (obj.equals(array[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }
    //Iterator is still fast but not as fast as iterative for loop.
    //FOR LOOP SUPREMACY
    @Override
    public java.util.Iterator<P> iterator(){
         return new java.util.Iterator<P>(){
             int index = 0;
             @Override
             public boolean hasNext(){
                 return index < size;
             }
             @Override
             public P next(){
                 return array[index++];
             }
             @Override
             public void remove(){
                 throw new UnsupportedOperationException();
             }
         };
    }
    @Override
    public String toString(){
         if(size == 0)
             return "[]";
         else{
             StringBuilder sb = new StringBuilder(size).append("[");
             for (int i = 0; i < size-1; i++) {
                 sb.append(array[i]+", ");
             }
             return sb.append(array[size-1] + "]").toString();
         }
    }
}
