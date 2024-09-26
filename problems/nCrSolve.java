package com.Data_Structures_byprayush.problems;

import java.io.*;
import java.util.*;

public class nCrSolve {


    public static long nCr(int n, int r) {
        if (r > n) {
            return 0;
        }
        if (r == 0 || r == n) {
            return 1;
        }

        r = Math.min(r, n - r);
        long res = 1;

        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int r = scan.nextInt();

        long result = nCr(n, r);
        System.out.println(result);
    }
}
