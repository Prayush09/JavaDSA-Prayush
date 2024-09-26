package com.Data_Structures_byprayush.problems;

import java.util.Scanner;

public class Exponentiation {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long result = computeModularExponentiation(a, b, c);
            System.out.println(result);
        }
        scanner.close();
    }

    // Function to compute base^exponent % mod using modular exponentiation
    private static long modularExponentiation(long base, long exponent, int mod) {
        long result = 1;
        base = base % mod; // Ensure base is within the range of mod
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            exponent = exponent >> 1; // Divide exponent by 2
            base = (base * base) % mod; // Square the base and take mod
        }
        return result;
    }

    // Function to compute a^(b^c) % mod
    private static long computeModularExponentiation(long a, long b, long c) {
        if (a == 0 && b == 0 && c == 0) return 1; // Handle 0^0 = 1
        long exponent_b_c = modularExponentiation(b, c, MOD);
        return modularExponentiation(a, exponent_b_c, MOD);
    }
}
