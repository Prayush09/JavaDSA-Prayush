package com.Data_Structures_byprayush.problems;

public class Swap_Two_Numbers {
    public static void swap_using_third_variable(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping: "+a+" & "+b);
    }
    public static void swap_without_third_variable(int a, int b)
    {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping: "+a+" & "+b);
    }
    public static void swap_with_bitwise_XOR(int a , int b)
    {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swapping: "+a+" & "+b);
    }
    public static void main (String[] args){
        swap_using_third_variable(4,5);
        swap_without_third_variable(5,6);
        swap_with_bitwise_XOR(57,28);
    }
}
