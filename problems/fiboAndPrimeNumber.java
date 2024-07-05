package com.Data_Structures_byprayush.problems;

import java.util.Scanner;

public class fiboAndPrimeNumber {

    public static int PrimeNumber(int n) {
        if (n < 2) return -1; // No prime number less than 2

        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (arr[p]) {
                for (int i = p * p; i <= n; i += p) {
                    arr[i] = false;
                }
            }
        }

        for (int i = n; i >= 2; i--) {
            if (arr[i]) {
                return i;
            }
        }
        return -1; // In case no prime number found
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        int[] ans = new int[n+1];
        for(int i = 0 ; i < ans.length; i++){
            if(i%2 == 0){
                //even
                ans[i] = fibonacci(i/2);
            }
            else{
                //odd
                ans[i] = PrimeNumber((i/2)+1);
            }
        }
        System.out.print(ans[n-1]);
    }
}
