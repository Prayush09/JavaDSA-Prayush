package com.Data_Structures_byprayush.problems;
import java.util.Scanner;
public class Uppercase_Lowercase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String s = in.next();
        char ch = s.trim().charAt(0); // Any Extra Space when inputing is removed using trim();
        if(ch >= 'a' && ch<= 'z')
        {
            System.out.println("LowerCase");
        }else
            System.out.println("UpperCase");



    }
}
