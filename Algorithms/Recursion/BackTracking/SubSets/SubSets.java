package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking.SubSets;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class SubSets {
   public static List<List<Integer>> subsets(int[] arr){
       List<List<Integer>> outer = new ArrayList<>();
       outer.add(new ArrayList<>());
       for(int num : arr){
           int n = outer.size();
           for(int i = 0 ; i  < n; i++){
               ArrayList<Integer> internal = new ArrayList(outer.get(i));
               internal.add(num);
               outer.add(internal);
           }
       }
       return outer;
    }


    public static List<List<Integer>> noDuplicateSubset(int[] arr) {
       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(arr); // Sort to handle duplicates
        generateSubsets(0, arr, new ArrayList<>(), result);
        return result;
   }

        private static void generateSubsets(int index, int[] arr, List<Integer> current, List<List<Integer>> result) {
            result.add(new ArrayList<>(current)); // Add the current subset to the result

            for (int i = index; i < arr.length; i++) {
                // Skip duplicates
                if (i > index && arr[i] == arr[i - 1]) {
                    continue;
                }

                // Include the current element and move to the next
                current.add(arr[i]);
                generateSubsets(i + 1, arr, current, result);
                // Exclude the current element to backtrack
                current.remove(current.size() - 1);
            }
        }



    public static void main(String[] args) {
       int[] arr = {1,2,2};
       List<List<Integer>> ans = noDuplicateSubset(arr);
       for(List<Integer> list : ans){
           System.out.println(list);
       }
    }
}
