package com.Data_Structures_byprayush.Algorithms.Recursion;

import java.util.Arrays;

public class merge_sort{

    //main method:
    public static void main(String[] args) {
        int[] data = new int[] {-8,-10,10,8,4,100,-34};
        mergeSort(data,0,data.length-1);
        System.out.println("Sorted array: "+ Arrays.toString(data));
    }

    public static void mergeSort(int[] data, int start, int end)
    {
        //if start has passed the end, then no work to do
        //so if start is less than end then we do work.
        if(start < end)
        {
          //we calculate the mid-point to divide the array.
          int mid = (start+end)/2;
          //Now we use recursion to divide the left side and right side,
          //further and further until only one element is left in the array.
          //left side array.
          mergeSort(data,start,mid);
          //right side array
          mergeSort(data,mid+1,end);
          //now to merge we will use another function called merge:
          merge(data,start,mid,end);
        }
    }

    public static void merge(int[] data, int start, int mid, int end){
        //buid a temp array to avoid modifying the original contents:
        int[] temp = new int[end - start + 1];
        //pointer for the left sub array
        int i = start;
        //pointer for the right sub array
        int j = mid+1;
        //pointer for the whole comparison operation
        int k = 0;
        //start a loop for the comparison:
        //while both sub-arrays have values, then try and merge them in sorted order.
        while(i <= mid && j <= end)
        {
          if(data[i] <= data[j])
          {
              temp[k] = data[i];
              i++;//increment after adding to temp.
              k++;//we don't overwrite the array.
              //you can simplify using temp[k++] = data[i++];
              //does the same thing.
          }else{
              temp[k] = data[j];
              j++;
              k++;
          }
        }
        //if values are left in the sub-array[left] then:
        while(i<=mid){
            temp [k++] = data[i++];
        }

        //if values are left in the right-sub array then:
        while(j<=end)
            temp[k++]=data[j++];

        //copying the values sub array to the original array:
        for(i = start; i <= end ; i++)
        {
            data[i] = temp[i-start];
        }
    }
}
