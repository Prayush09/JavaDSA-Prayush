package com.Data_Structures_byprayush.Algorithms.BackTracking;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersToAlphabetMapping {

        public static List<String> convertNumberToAlphabets(String digits) {
            List<String> result = new ArrayList<>();
            if(digits == null || digits.length() == 0)
                return result;
            String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            backtracking(digits, new StringBuilder(), map, result, 0);
            return result;
        }

        private static void backtracking(String digits, StringBuilder temp, String[] map, List<String> result, int index) {
            if(index == digits.length()) {
                result.add(temp.toString());
                return;
            }
            else {
                String current = map[digits.charAt(index) - '0'];
                for(char c: current.toCharArray()) {
                    temp.append(c);
                    backtracking(digits, temp, map, result, index + 1);
                    temp.deleteCharAt(temp.length() - 1);
                }
            }
        }

        public static void main(String args[]) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            String s = Integer.toString(n);
            List<String> result = convertNumberToAlphabets(s);
            for (String str : result) {
                System.out.print(str + " ");
            }
            System.out.println(); // Print a newline after printing all elements
            scan.close();
        }

}

