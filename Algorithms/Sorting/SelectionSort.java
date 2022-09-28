package com.Data_Structures_byprayush.Algorithms.Sorting;

import java.util.Arrays;
public class SelectionSort {
    public int[] selection_sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)//Traversing through whole array
        {
            //assigning the minimum index value of i.
            int min_index = i;
            //Starting second loop from i+1 position till last position,
            // here j = 1 for first iteration
            // therefore we need to go till j<n and not j<n-1.
            for(int j=i+1;j<n;j++)
                //If any index that is greater than i has a smaller value,
                // we assign that j index to min_index;
                //We repeat this for loop until we get
                if(arr[j]<arr[min_index])
                    min_index=j;
            //Reversing the numbers using indexes.
            int temp = arr[min_index];
            arr[min_index]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }
    public void print_arr(int[] arr)
    {
        int n = arr.length;
        System.out.println("The Sorted Array using selection sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            System.out.println();
        }
    }
}













//public class SelectionSort {
//    public static void main(String[] args) {
//        int[] arr = { 15, 20, 10, 30, 50, 18, 5, 45 };
//        int min;
//        for (int i = 0; i < arr.length; i++) {
//            min = i;
//            //Finding the minimum element in the array.
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[min]) {
//                    min = j;
//                }
//            }
//            //Shifting the minimum element
//            if (min != i) {
//                int temp = arr[i];
//                arr[i] = arr[min];
//                arr[min] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//    }
//}

