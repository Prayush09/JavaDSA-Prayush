package com.Data_Structures_byprayush.Basics;
import java.lang.Integer;
import java.util.Scanner;
public class Hamming_weight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        System.out.println(Integer.bitCount(n));
    }
}
