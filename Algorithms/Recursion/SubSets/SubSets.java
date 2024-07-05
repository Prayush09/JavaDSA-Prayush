package com.Data_Structures_byprayush.Algorithms.Recursion.SubSets;
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

    public static List<List<Integer>> onlyUniqueSubset(int[] arr){
       List<List<Integer>> outer = new ArrayList<>();
       Arrays.sort(arr);
       outer.add(new ArrayList<>());
       int prevNum = Integer.MIN_VALUE;
       for(int num : arr){
           if(num == prevNum)
                continue;
           int n= outer.size();
           for(int i = 0 ; i < n; i++){
               //sort the array sequence
               ArrayList<Integer> internal = new ArrayList(outer.get(i));
               internal.add(num);
               outer.add(internal);
           }
           prevNum = num;
       }
       return outer;
    }

    public static List<List<Integer>> noDuplicateSubset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(arr);
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < arr.length;i++){
            //skip the subsets with which the current number will generate duplicates, end here is from the prev iteration.
            start = (i>0 && arr[i] == arr[i-1]) ? end+1 : 0;
            end = outer.size()-1;
            int n= outer.size();
            for(int j = start ; j < n; j++){
                //sort the array sequence
                ArrayList<Integer> internal = new ArrayList(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);//outer size increases, but end is not increased because we need the diff between
                //start and end to store unique subsets that may contain the same elements.
            }

        }
        return outer;
    }

    public static void main(String[] args) {
       int[] arr = {1,2,2};
       List<List<Integer>> ans = noDuplicateSubset(arr);
       for(List<Integer> list : ans){
           System.out.println(list);
       }
    }
}
