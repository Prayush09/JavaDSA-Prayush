package com.Data_Structures_byprayush.Algorithms.Recursion;

public class RotatedBinarySearch {
    public static int search(int[] arr, int key, int start, int end){
        if(start>end){
            return -1;
        }
        int middle = (start+end)/2;
        //array is sorted
        if(arr[start]<= arr[middle]){
            //locating which side is the key
            if(key == arr[middle]) return middle;
            if(key>=arr[start] && key<=arr[middle])
                return search(arr,key,start,middle-1);
            else
                return search(arr,key,middle+1,end);
        }
        //if array is unsorted
        if(key>= arr[start] && key <= arr[middle])
            return search(arr,key,start,middle-1);
        return search(arr,key,middle+1,end);
    }

    public static void main(String[] args) {
        int[] arr = {378,3509,10,30506,304,56};
        int target = 56;
        System.out.println(search(arr,target,0,arr.length-1));
    }
}
