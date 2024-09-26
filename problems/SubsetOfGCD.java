package com.Data_Structures_byprayush.problems;

import java.io.*;
import java.util.*;

public class SubsetOfGCD {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static int findGCD(int[] arr, int n) {
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result = gcd(result, arr[i]);
            if (result == 1) {
                return 1; // GCD of the whole array is 1
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();

        int gcdOfArray = findGCD(arr, n);

        // Output the result
        if (gcdOfArray == 1) {
            System.out.println(n);
        } else {
            System.out.println(0);
        }
    }
}
