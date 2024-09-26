package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {

    public static List<String> pad(String processed, String unprocessed){
        if(unprocessed.isEmpty())//no more digits left
        {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> ans = new ArrayList<>();
        int currDigit = unprocessed.charAt(0) - '0';//convert '2' -> 2 (e.g.)
        for(int i = (currDigit-1)*3 ; i < currDigit*3 ; i++){
            //create the corresponding character
            char a = (char)('a' + i); //a + 3 = d
            ans.addAll(pad(processed+a,unprocessed.substring(1)));
        }
        return ans;
    }
    public static List<String> letterCombinations(String digits) {
        //figure out the range
        List<String> ans = pad("",digits);
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans = letterCombinations("12");
        for(String s : ans){
            System.out.println(s);
        }
    }
}
