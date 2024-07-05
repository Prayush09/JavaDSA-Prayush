package com.Data_Structures_byprayush.Data_Structures.Linear;


import java.util.*;

public class LongestNonRepeatingSubstring {
    public static String LongestSubstringNonDuplicate(String s){
        //a function to insert
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        String longest = "";
        while(right<s.length()){
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                //update the length and add it to longest string
                if(right-left+1 > maxLength){
                    maxLength = right-left+1;
                    longest = s.substring(left,right+1);
                }
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(LongestSubstringNonDuplicate(input));
    }
}
