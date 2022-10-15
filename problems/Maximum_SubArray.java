package com.Data_Structures_byprayush.problems;
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class Maximum_SubArray {
    public int sum(int[] arr)
    {
       int currentvalue = 0;
       int MaxValue = Integer.MIN_VALUE;
       if(arr.length == 1)
           return arr[0];
        for (int i = 0; i < arr.length; i++) {
            currentvalue += arr[i];//Storing the +ve values.
            if(currentvalue>MaxValue)

                MaxValue = currentvalue;
            if(currentvalue<0)
                currentvalue=0;//Negates the -ve values.
        }
        return MaxValue;
    }
}
