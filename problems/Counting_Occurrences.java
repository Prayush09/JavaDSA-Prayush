package com.Data_Structures_byprayush.problems;
import java.util.Scanner;


public class Counting_Occurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number: ");
        int n= scan.nextInt();
        System.out.println("Please enter the digit for number of occurrences");
        int digit = scan.nextInt();
        int count =0;
        //If you use modulus '%' with 10 for any number then you are going ot get the last value.
        //example: n = 1034 / 10 = 103 and remainder = 4 which is the last digit. so using modulus will give the last digit.
        //Will I Know till what time the loop will run? NO because we are taking user input.

        while(n>0) {
           int rem = n % 10;
           if(rem == digit)
               count++;
           n/=10;
        }
        System.out.println("The number of occurrences is: "+count);
    }

}
