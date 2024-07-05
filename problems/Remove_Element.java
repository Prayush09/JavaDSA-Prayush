package com.Data_Structures_byprayush.problems;

public class Remove_Element {
    public int removeElement(int[] nums, int val)
    {
        //index to be returned
        int k = 0;
        if(nums.length==0)
            return 0;
        int end = nums.length-1;
        int temp = 0;
        for(int start = 0; start < nums.length ; start++)
        {

            if(nums[start] == val)
            {
                if(nums[end]==val)
                    end--;
                if(end!=val)
                {
                    temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;

                }
            }
            if(nums[start]==nums[end])
                k = start;
        }

        return k;
    }
}
