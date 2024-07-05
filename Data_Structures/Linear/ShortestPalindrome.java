package com.Data_Structures_byprayush.Data_Structures.Linear;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShortestPalindrome {
    //we just have to return the  lexicographically smallest character present in the string.
    public static char ShortestPalindrome(String s){
        //a function to insert
        int n = s.length();
        char ans = s.charAt(0);

        for(int i = 1; i < s.length();i++){
            ans = (char) Math.min(ans, s.charAt(i));
        }
        return ans;
    }

        public static String shortestPalindrome(String s) {
            int n = s.length();
            int i = 0;

            // Find the longest palindrome suffix starting from the beginning of the string
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                }
            }

            // If the whole string is a palindrome, return the original string
            if (i == n) {
                return s;
            }

            // Otherwise, add the remaining characters in reverse order in front of the string
            StringBuilder prefix = new StringBuilder(s.substring(i)); // Remaining characters
            return prefix.reverse().toString() + s;
        }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(ShortestPalindrome(s));
        System.out.println(shortestPalindrome(s));
    }
}

