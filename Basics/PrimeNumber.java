package com.Data_Structures_byprayush.Basics;

import java.util.Scanner;

public class PrimeNumber
{

    static boolean isPrime(int n){
        if(n <= 1)
            return false;
        int c = 2;
        while(c*c<=n){
            if(n % c == 0)
                return false;//After a return the program is over and the while loop is exited!
            c++;
        }
        return c*c>n;//The condition itself will either return true or false.
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(isPrime(n));
    }
}