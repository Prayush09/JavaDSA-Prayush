package com.Data_Structures_byprayush.Algorithms.Recursion;

public class LinearSearch {
    public static boolean linearSearch(int[] arr, int target, int index){
        if(arr[index]==target)
            return true;
        if(index == arr.length-1)
            return false;
        return linearSearch(arr,target,index+1);
    }

    //better way to write:
    public static boolean linearSearch1(int[] arr, int target, int index){
        if(index == arr.length)
            return false;
        return arr[index] == target || linearSearch1(arr,target,index+1);
        // if false then linear search will continue, else true will be returned.
    }

    public static void main(String[] args) {
        int[] arr= {1,5,23,56,467};
        int target = 467;
        System.out.println(linearSearch(arr,target,0));
        System.out.println(linearSearch1(arr,target,0));
    }
}
