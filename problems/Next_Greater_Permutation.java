package com.Data_Structures_byprayush.problems;

import java.util.Arrays;

public class Next_Greater_Permutation {

    public static int[] reverseArray(int[] arr,int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public static int[] nextPermutation(int[] arr){
        //find the break point : from the back of the array: arr[i] < arr[i+1]
        int breakPoint = -1;
        for(int i = arr.length-2; i>=0; i--){
            if(arr[i]<arr[i+1])
                breakPoint = i;
        }
        //if breakPoint == -1 then reverse the array and return the array
        if(breakPoint == -1)
            return reverseArray(arr,0,arr.length-1);
        else {
            //find the smallest number on the right side of the array(just greater than breakPoint)
            int j = arr.length-1;
            while (arr[j] <= arr[breakPoint])
                j--;
            //swap the elements at breakPoint and at index j
            int temp = arr[j];
            arr[j] = arr[breakPoint];
            arr[breakPoint] = temp;
        }
        return reverseArray(arr, breakPoint + 1, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] pr = {1,3,2};
        int[] ans = nextPermutation(pr);
        System.out.println(Arrays.toString(ans));
    }
}
