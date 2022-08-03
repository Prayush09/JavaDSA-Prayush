package com.Data_Structures_byprayush;
//Creating a dynamic array using static arrays.

/**
 * Accessing a static array takes O(1) time complexity meaning constant time and not dependent on input size.
 * Searching for an element in a static array takes O(n) time complexity meaning linearly increasing time v/s input size..
 * Access means the opportunity to approach or enter a place.
 * Searching means to look into or over carefully or thoroughly in an effort to find something.
 * To insert an element into a static array we need to first shift all the elements from that index where insertion will take place, one block to the right making room for the inserting element.
 * To delete and element we do the opposite, that is first we delete that element and then shift all the elements to the left of the array.
 * NOTE: The size of a static array is fixed upon instantiation.
 * To make a dynamic array we can use static arrays by applying this logic:
 * If the static array has reached its capacity then we can double the size of the array and shift all the elements from this static array to this new static array therefore increasing the space, which means that this mechanism will act as a DYNAMIC ARRAY.
 * Advantages of Dynamic array: 1. Random access of elements O(1)
 *                              2. Good locality of reference and data cache utiliztion.
 *                              3. Easy to insert/delete at the end.
 * Disadvantages of Dynamic array: 1. Wastes more memory.
 *                                 2. Shifting elements is time consuming O(n).
 *                                 3. Expanding/Shrinking the array is time consuming O(n).
 * The size in a dynamic array means that the total number of index holding a value(which is not a garbage value or null).
 * The capacity of a dynamic array means the total number of indexes exisiting in that array meaning all the values including the null/garbage values.
 * E.g. if an array is initiated like this int [] array = new int[10];
 *         and then given values like this array = {1,2,3,4,5};
 *         this means that starting from 0, only 5 index have been filled remaining 5 have null/garbage value.
 *    => The Size of this array is 5 and the capacity of this array is 10.
 *    Also, we can use size to fill the next element into the array as size is always greater than currently filled indexes, since the index starts from 0.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Dynamic_Arrays {
    //The size grows automatically when we try to insert an element, if there is no more space left for the new element
    int size;//Size of the Dynamic array which also signifies the end of the array.
    int capacity = 10; //default capacity of the static array, can be changed using constuctor.
    Object[] array;//an array using object class.
    //Constructor for giving capacity value to the 'array' of Object class.
    Dynamic_Arrays(){
        this.array = new Object[capacity];
    }
    //Overloading constructor for if user wants to give the capacity of the array.
    Dynamic_Arrays(int capacity){
        this.capacity = capacity;
        this.array = new Object[capacity];
    }
    //Now Creating methods for the dynamic array like add, insert, delete, search, shirnk, grow, isEmpty, toString.
    public void add(Object data){
          //First we want to check if we are at capacity.
        if(size >= capacity){
            grow(); //if size of the array is greater than capacity then we call grow method to get a bigger capacity, so we can add the element.
        }
        array[size++] = data; //To store data to the last index we use size, and then increment it so that if we want to add another element,
        //then it won't replace the data we added before and get stored in the null block only.
    }
    public void insert(int index, Object data){
         if(size >= capacity){
             grow();
         }
         //The values to shift from left to right require that I take the values at the left side in the array and store it in the right size.
        //I take i = size as this is the right most value in the array and after it all the elements are either null or don't exist.
        //then I iterate i to go the left side till i > index and inside the loop i take the element on the left side that is array[i - 1] and put store it at array[i]...
        // Basically jumping the elements from left to right while I go from right to left till the index value.
         for(int i = size; i > index; i--)
         {
             array[i]=array[i-1];
         }
         array[index] = data;
         size++;//We are inserting which means we are increasing the size of the array.
    }
    public void delete(Object data){
        //iterating over each element in the array.
        for (int i = 0; i < size; i++) {
            //When we find the data for deletion in the array
            if(array[i]==data){
                //Using a nested array to delete and shift the elements to the left.
                //We initialise j = i as a starting and iterate it till size.
                for (int j = i; j <= size ; j++) {
                    //when iterating till size we shift the right index value to the current index value
                    array[j]= array[j+1];
                }
                //After shifting we decrease the overall size as we have just removed an element.
                size--;
                //Adding a shrink function if the capacity>>size.
                if(size <= (int)(capacity/3)){
                    shrink();
                }
                break;
            }
        }
    }
    public int search(Object data){
        for(int i = 0; i < size ; i++)
        {
            if(array[i]==data)
                return i;
        }
        return -1;
    }
    //We use private in grow and shrink because we are transferring data and/or adding/deleting data from one array to another.
    private void grow(){
       int newCapacity = (int)(capacity * 2);
       Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }
    private void shrink(){
        //To grow we multiply capacity by a constant, to shrink we divide.
        int newCapacity = (int)(capacity / 2);
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }
    public boolean isEmpty(){
        return size == 0;// If/when the size of the array is 0 then isEmpty will return false.
    }
    //No parameter needed for toString as we will convert the whole dynamic array into a string to display the results.
    public String toString(){
        String s = "";//empty string
        //iterating over each element in the array until size because after that the values are garbage or null, and using ,[space] to make it look cleaner.
        //You can change size to capacity to view the remaining garbage/null values in the array.
        for (int i = 0; i < capacity; i++) {
         s += array [i] + ", ";
        }
        //To remove extra ',' we can use an if function.
        //If the string is not empty then we cut the string using substring method where we go from 0 start index to s.length - 2, now - 2 because we have two strings after array[i], which is ','&'[space] so we use -2.
        if(s != ""){
            s ="["+ s.substring(0 , s.length()-2) + "]";
        }
        else{
            s = "[]";
        }
        return s;
    }


}
