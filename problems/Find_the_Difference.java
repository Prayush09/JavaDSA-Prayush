package com.Data_Structures_byprayush.problems;

public class Find_the_Difference {
    public char findTheDifference(String s, String t){
        char a = 0;
        for(char cs : s.toCharArray())
            a ^= cs;
        for(char ct : t.toCharArray())
            a ^= ct;
        return a;
    }

    public static void main(String[] args) {
        Find_the_Difference obj1 = new Find_the_Difference();
        System.out.println(obj1.findTheDifference("","y"));
    }
}
