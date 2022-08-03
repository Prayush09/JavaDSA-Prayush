package com.Data_Structures_byprayush.problems;
import java.util.Scanner;
public class Fibonacci_Series {
    public static void main(String[] args) {
        int n,index,previous;
        int temp;
        Scanner scan = new Scanner(System.in);
        previous=0;
        index=1;
        System.out.println("Please enter the index of the number in Fibonacci Series: ");
        n=scan.nextInt();
        int count = 2;
        while(count<=n)
        {
            temp = index;
            index+=previous;
            previous = temp;
            count++;
        }
        System.out.println("The required Fibonacci Series is: "+index);
    }
}