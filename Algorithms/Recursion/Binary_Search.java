package com.Data_Structures_byprayush.Algorithms.Recursion;

public class Binary_Search {
    public static int BinarySearch(int[] array, int left, int right, int tofind)
    {
        //base case 1:
        //if left pointer has crossed right pointer in array.
        if(left > right)
            return -1;
        //find the mid point of the array:
        int mid = (left+right)/2;
        //checking base case 2:
        //if the mid point is the place where we tofind number:
        if(array[mid]==tofind)
            return mid;
        //if tofind number is on the left side of the array
        //Recursion on the left side of the array:
        if(tofind<array[mid])
            return BinarySearch(array,left,mid-1,tofind);
        //if tofind number is on the right side of the array.
        //Recursion on the right side of the array:
        return BinarySearch(array,mid+1,right,tofind);
    }

    public static void main(String[] args)
    {
        int[] ar = {10,20,30,40,50,60};
        System.out.println(BinarySearch(ar,0,ar.length-1,30));
    }
}
