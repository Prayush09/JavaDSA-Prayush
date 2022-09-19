package com.Data_Structures_byprayush;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {53,5,325,235,6,346,73};
        int i,j,temp;
        for(i = 1; i<arr.length ; i++)
        {
            j = i - 1;
            while(j>=0 && arr[j]>arr[i])
            {
                temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i = j;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}