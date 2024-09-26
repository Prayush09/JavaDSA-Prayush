package com.Data_Structures_byprayush.problems;

import java.util.Scanner;

public class excludeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.next();
        String m = sc.next();
        sc.close();
        int start = 0;
        int end = 0;
        String ans = "";

        while (start < t.length()) {
            if (end < m.length() && t.charAt(start) == m.charAt(end)) {
                end++;
                start++;
                if (end == m.length()) {
                    end = 0;
                }
            } else {
                if (end > 0) {
                    // Append characters matched so far to the result
                    ans = ans + t.substring(start - end, start);
                    start = start - (end - 1); // Move start back to recheck next character
                    end = 0;
                } else {
                    ans = ans +  t.charAt(start);
                    start++;
                }
            }
        }

        // Append remaining characters if partial match at the end
        if (end > 0) {
            ans += t.substring(start - end, start);
        }

        System.out.print(ans);
    }
}
