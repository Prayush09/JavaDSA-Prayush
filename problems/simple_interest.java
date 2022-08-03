package com.Data_Structures_byprayush.problems;
import java.util.Scanner;

public class simple_interest {
    public static void main(String [] args)
    {
        Scanner scan = new Scanner (System.in);
        int P,R,T;
        System.out.println("Principle: ");
        P = scan.nextInt();
        System.out.println("Rate of Interest: ");
        R = scan.nextInt();
        System.out.println("Time: ");
        T = scan.nextInt();
        int simple_interest = (P*R*T)/100;
        System.out.println("The simple interest is: "+ simple_interest);
    }
}
