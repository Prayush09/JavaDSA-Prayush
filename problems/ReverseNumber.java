package com.Data_Structures_byprayush.problems;
import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a number to be reversed : ");
        int input = scan.nextInt();
        int result = 0;
        while(input>0)
        {
           int remainder = input % 10 ;
           result = result * 10 + remainder;//shifting the digit extracted from input to one's place in the result.
            input /= 10;
        }
        System.out.println("Reversed Number : " + result);
    }
}
