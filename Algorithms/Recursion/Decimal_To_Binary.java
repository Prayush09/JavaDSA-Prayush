package com.Data_Structures_byprayush.Algorithms.Recursion;

public class Decimal_To_Binary {
    public static String DecimalToBinary(int input, String result)
    {
        if(input == 0)
            return result;
        result = input % 2 + result;
        return DecimalToBinary(input/2, result);
    }
    public static void main(String[] args)
    {
        String binary = DecimalToBinary(10,"");
        System.out.println(binary);
    }
}
