package com.Data_Structures_byprayush.problems;
import java.util.HashSet;
import java.util.Arrays;
//Using HashSet
public class Duplicate_Element {
    public boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            if (hashset.contains(num))
                return true;
            hashset.add(num);
        }
                return false;
    }
}
//Using Arrays.
class ContainsDuplicate{
    public boolean Contains_duplicate(int[] nums)
    {
        Arrays.sort(nums);
        int[] ans = new int[2];
        if(nums.length>1)
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i]==nums[i+1])
                    return true;
            }
        return false;
    }
}
