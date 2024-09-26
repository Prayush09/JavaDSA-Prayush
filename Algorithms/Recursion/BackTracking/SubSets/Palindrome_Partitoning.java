package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking.SubSets;

import java.util.ArrayList;
import java.util.List;


public class Palindrome_Partitoning {
    public static void subsets(String s, int start, List<String> currentPartition, List<List<String>> ans) {
        // Base case: if start index reaches the end of the string, add the current partition to the answer
        if (start == s.length()) {
            ans.add(new ArrayList<>(currentPartition));
            return;
        }

        // Try all possible end indices for substrings starting from 'start'
        for (int end = start; end < s.length(); end++) {
            // Check if the current substring is a palindrome
            if (isPalindrome(s, start, end)) {
                // If it's a palindrome, add it to the current partition
                currentPartition.add(s.substring(start, end + 1));
                // Recur for the remaining substring
                subsets(s, end + 1, currentPartition, ans);
                // Backtrack by removing the last added substring
                //In this backtrack, the for-loop for each recursive function will get a chance
                //to either complete or give out another answer.... that's how backtracking is working
                // here.
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        subsets(s, 0, new ArrayList<>(), ans);
        return ans;
    }
        public static void main (String[]args){
            List<List<String>> ans = partition("aab");
            System.out.println(ans);
        }
}
