package com.Data_Structures_byprayush.Algorithms.Recursion;
import java.util.Scanner;
public class Greatest_common_divisor {
    public static int GetGCD(int smaller, int bigger)
    {
        if(bigger == 0)
            return smaller;
        return GetGCD(bigger,smaller%bigger);
    }

    public static void main(String[] args) {
        System.out.println("Enter two numbers:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();
        System.out.println("The greatest common divisor of these two number is: "+ GetGCD(a,b));

    }
}
