package com.Data_Structures_byprayush.Algorithms.DynamicProgramming;

import java.util.*;

public class LeastIncreasingSubSequence {

    public static int BinarySearch(List<Integer> list, int num){
        int low = 0;
        int high = list.size();

        while(low < high){
            int middle = low + (high - low)/2;

            if(list.get(middle) < num){
                low = middle+1;
            }
            else{
                high = middle;
            }
        }
        return low;
    }

    public static int LIS(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            int pos = BinarySearch(list, num);
            if(pos < list.size())//it is inside the answer list
            {
                if(Objects.equals(list.get(list.size() - 1), list.get(pos))){
                    list.add(num);
                }

                list.set(pos, num);
            }
            else{
                list.add(num);
            }
        }
        return list.size();
    }

    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n;i++){
            nums[i] = scan.nextInt();
        }
        int ans = LIS(nums);
        System.out.print(ans);
    }
}
