package com.Data_Structures_byprayush.Basics;
import java.io.*;
import java.util.*;
/*
Vector class implements a growable array of objects
Vectors fall in legacy classes,
but now it is fully compatible with collections.
it is found in java.util. package and
implement the List interface,
so we can use all the methods
of the list interface as shown below as follows:
 */


//Constructors of different types of vectors.
public class Vectors {
    public static void main(String[] args)
    {
        //Size of the vector
        int size = 10;
        //Declaring the vector:
        Vector<Integer> vector1 = new Vector<>(size);

        //Appending new elements at the end of the vector
        for (int i = 0; i < size; i++)
            vector1.add(i);
        //Printing the elements
        System.out.println(vector1);
        //Remove elements at index 3
        vector1.remove(3);
        //Displaying the vector after deletion
        System.out.println(vector1);
        //iterating over vector elements using for loops
        for (Integer integer : vector1) {
            System.out.println(integer + " ");
        }
    }
}
