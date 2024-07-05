package com.Data_Structures_byprayush.Data_Structures.Linear;
import java.util.*;
/*
Algorithm Overview:
Initialize start and end variables to keep track of the starting and ending indices of the longest palindromic substring.
Iterate through each character of the input string s.
For each character, expand around it by calling the expand_around_center function with two different center possibilities: (i) the current character as the center (odd length palindrome), and (ii) the current character and the next character as the center (even length palindrome).
Compare the lengths of the two expanded palindromes and update start and end if a longer palindrome is found.
Finally, return the longest palindromic substring by slicing the input string s based on the start and end indices.
 */
public class PalindromicString {
    public static String LongestPalindrome(String s){
        int start = 0;
        int end = 0;
        for(int i = 0 ;i < s.length();i++){
            int even = expand_around_center(s,i,i+1);
            int odd = expand_around_center(s,i,i);
            int maxLenght = Math.max(even,odd);
            if(maxLenght>(end-start)){
                start = i - (maxLenght-1)/2;
                end = i + maxLenght/2;
            }
        }
        //substring end is not inclusive, therefore +1.
        return s.substring(start,end+1);
    }
    public static int expand_around_center(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(LongestPalindrome(s));
    }
}
