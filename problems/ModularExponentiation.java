package com.Data_Structures_byprayush.problems;

import java.util.Scanner;

public class ModularExponentiation {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            if (a == 0 && b == 0) {
                System.out.println(1);
            } else {
                System.out.println(modularExponentiation(a, b, MOD));
            }
        }

        scanner.close();
    }

    private static long modularExponentiation(long a, long b, int mod) {
        long result = 1;
        a = a % mod;  // Update 'a' if 'a' >= mod
        while (b > 0) {
            // If 'b' is odd, multiply 'a' with the result
            if ((b&1)==1) {
                result = (result * a) % mod;
            }
            // 'b' must be even now
            b = b >> 1;  // 'b' = b // 2
            a = (a * a) % mod;  // Change 'a' to 'a^2'
        }
        return result;
    }
}
