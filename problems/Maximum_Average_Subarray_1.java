package com.Data_Structures_byprayush.problems;
import java.util.*;
public class Maximum_Average_Subarray_1 {
        public double findMaxAverage(int[] nums, int k) {
            //Find the maximum sum in the array taking only k digits.
            double max = Integer.MIN_VALUE;
            if(nums.length==1)
                return (double)nums[0];
            for(int i = 0 ; i <= nums.length-k ; i++)
            {
                double sum = 0;
                for(int j = i; j < k+i ; j++)
                {
                    sum = sum + (double)nums[j];
                }
                if(sum>max)
                    max = sum;
            }
            max = max/k;
            return max;
        }

        public double MaxAverage(int[] nums, int k)
        {
            int windowSum = 0;
            int maxSum = Integer.MIN_VALUE;
            for(int i = 0 ; i < k ; i++)
            {
                windowSum = windowSum + nums[i];
            }
            for(int i = k ; i < nums.length ; i++)
            {
                windowSum = windowSum - nums[i-k] + nums[i];
                maxSum = Math.max(maxSum,windowSum);
            }
            return maxSum/(k*1.0d);
        }
    }
//THIS METHOD WORKS BUT FOR A SMALL INPUT OF K.
//For this we will have to use the "SLIDING WINDOW" method.

