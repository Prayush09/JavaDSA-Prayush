package com.Data_Structures_byprayush.problems;

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class storeRainWater {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Read the input size
        int n = scan.nextInt();
        int[] height = new int[n];

        // Read the heights
        for (int i = 0; i < n; i++) {
            height[i] = scan.nextInt();
        }

        // Compute the trapped water
        int trappedWater = trap(height);

        // Print the result
        System.out.println(trappedWater);
    }

    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }
}
