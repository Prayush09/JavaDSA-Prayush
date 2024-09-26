package com.Data_Structures_byprayush.problems;

class Main {

    public static long minimumReplacement(int[] nums) {
        int n = nums.length;
        int prev = nums[n-1];
        long result = 0;
        for(int i = n-2; i >= 0;i--){
            if(prev >= nums[i]){
                prev = nums[i];
            }
            else{
                int parts = (int)Math.ceil((double)nums[i]/prev)-1;
                result+=parts;
                prev = Math.min(prev,nums[i]/(parts+1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(minimumReplacement(new int[]{12,9,7,6,17,19,21}));
    }
}