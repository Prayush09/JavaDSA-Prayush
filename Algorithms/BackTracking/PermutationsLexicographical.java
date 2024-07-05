package com.Data_Structures_byprayush.Algorithms.BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class

PermutationsLexicographical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        input = new String(chars);
        generatePermutations(input, "");
        scanner.close();
    }

    private static void generatePermutations(String input, String current) {
        if (input.length() == 0) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String remaining = input.substring(0, i) + input.substring(i + 1);
            generatePermutations(remaining, current + ch);
        }
    }
}
