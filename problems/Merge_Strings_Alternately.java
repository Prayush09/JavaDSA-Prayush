package com.Data_Structures_byprayush.problems;
import java.util.Scanner;

public class Merge_Strings_Alternately {
//Optimized version:=]
    public String MergeString(String s1,String s2){
          int first = 0;
          int second = 0;
           StringBuilder sb1 = new StringBuilder();
           while(first<s1.length() || second < s2.length()){
               if(first<s1.length())
                   sb1.append(s1.charAt(first));
               if(second<s2.length())
                   sb1.append(s2.charAt(second));
               first++;
               second++;
           }
           return sb1.toString();
    }


    public static void main(String[] args) {
//--------------------------MY SOLUTION--------------------------------------------
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the first word: ");
//        String word1 = scan.next();
//        System.out.println("Enter the second word: ");
//        String word2 = scan.next();
//        int min = Math.min(word1.length(),word2.length());
//        String merged = "";
//        if(word1.length() == word2.length())
//        {
//            for (int i = 0; i < min; i++)
//                merged = merged + word1.charAt(i) + word2.charAt(i);
//            System.out.println(merged);
//        }
//        if(word1.length()>word2.length()){
//            for (int i = 0; i < min; i++)
//                merged = merged + word1.charAt(i) + word2.charAt(i);
//            merged += word1.substring(word2.length(),word1.length());
//            System.out.println(merged);
//        }
//        if(word2.length()>word1.length())
//        {
//            for (int i = 0; i < min; i++)
//                merged = merged + word1.charAt(i) + word2.charAt(i);
//            merged += word2.substring(word1.length(),word2.length());
//            System.out.println(merged);
//        }
//---------------------------------------------------------------------------------------
        Merge_Strings_Alternately obj1 = new Merge_Strings_Alternately();
        System.out.println(obj1.MergeString("ab","pqrs"));

    }
}
