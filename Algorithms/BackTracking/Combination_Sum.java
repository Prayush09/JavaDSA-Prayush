package com.Data_Structures_byprayush.Algorithms.BackTracking;

import java.util.ArrayList;

public class Combination_Sum {
    public static ArrayList<ArrayList<Integer>> Combination(int[] arr, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return result;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] <= target) {
                temp.add(arr[i]);
                Combination(arr, target - arr[i], temp, result, i);
                temp.remove(temp.size() - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        int index = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Combination(arr, target, temp, result, index);
        System.out.println(result);
    }
}
