package com.Data_Structures_byprayush;

import java.util.Arrays;
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 15, 20, 10, 30, 50, 18, 5, 45 };
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            //Finding the minimum element in the array.
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //Shifting the minimum element
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}