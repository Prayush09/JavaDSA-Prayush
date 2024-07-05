package com.Data_Structures_byprayush.Algorithms.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        // Number of pairs of parentheses
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<String> combinations = generateParenthesis(n);
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
