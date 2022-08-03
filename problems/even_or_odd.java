package com.Data_Structures_byprayush.problems;
import java.util.Scanner;
//when is a number even or odd -> if the number is divisible by 2 then its even
// otherwise it's odd.
public class even_or_odd {
    public static void main(String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("Please enter a number");
        int input = scan.nextInt();
        if(input % 2 == 0)
            System.out.println("The given number is Even");
        else
            System.out.println("The given number is Odd");
    }
}
