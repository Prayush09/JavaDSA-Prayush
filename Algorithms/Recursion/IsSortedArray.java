package com.Data_Structures_byprayush.Algorithms.Recursion;

public class IsSortedArray {
    public static boolean isSorted(int[] arr){
        int index = 0;
        return helper(arr,index);
    }

    private static boolean helper(int[] arr, int index) {
        if(index == arr.length - 2 && arr[index] <= arr[index + 1])
            return true;
        if(arr[index] <= arr[index + 1]){
            return helper(arr,index+1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 99; i >= 0;i--){
            arr[i] = i+1;
        }
        System.out.println(isSorted(arr));
    }
}
