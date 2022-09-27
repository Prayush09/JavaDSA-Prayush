package com.Data_Structures_byprayush.problems;
//https://www.youtube.com/watch?v=5D9OrHsw3M0
public class Rotate_Array {
    public void rotate(int[]nums,int k)
    {
      int n = nums.length;
      k = k % n;
      reverse(nums,0,n-k-1);//rotating the first white block
      reverse(nums,n-k,n-1);//rotating the second orange block
      reverse(nums,0,n-1);//rotating the whole array.
    }
    void reverse(int [] arr, int start, int end)
    {
        while(start<end)
        {
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

}
