package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking.SubSets;

import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
        //subseq("","aab");
        ArrayList<String> ar1 = subseqArrayList("","aab");
        //ArrayList<String> ar = AsciiSubseq("","abcd");
       //System.out.println(ar);
        System.out.println(ar1);
    }

    //returning subsets
    public static ArrayList<String> subseqArrayList(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> left = subseqArrayList(processed+ch,unprocessed.substring(1));
        ArrayList<String> right = subseqArrayList(processed,unprocessed.substring(1));
        left.addAll(right);
        return left;
    }

    //printing subsets
    public static void subseq(String processed,String unprocessed){
        //base condition states: whenever unprocessed is empty -> print processed
        if(unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        //take the first char of the string and make two rec calls
        //first to take it
        //second to ignore it
        char ch = unprocessed.charAt(0);
        subseq(processed+ch,unprocessed.substring(1));
        subseq(processed,unprocessed.substring(1));
    }

    public static ArrayList<String> AsciiSubseq(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> left = AsciiSubseq(processed+" "+(ch+0),unprocessed.substring(1));
        ArrayList<String> right = AsciiSubseq(processed,unprocessed.substring(1));
        left.addAll(right);
        return left;
    }
}
