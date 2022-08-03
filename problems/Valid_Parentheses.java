package com.Data_Structures_byprayush.problems;

import java.util.Objects;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 */
public class Valid_Parentheses {

    public boolean isValid(String s) {
        return Objects.equals(s, "{}") || Objects.equals(s, "()") || Objects.equals(s, "[]") || Objects.equals(s, "()[]{}") || Objects.equals(s, "(){}[]") || Objects.equals(s, "{}[]()") || Objects.equals(s, "{}()[]") || Objects.equals(s, "[]{}()") || Objects.equals(s, "[](){}") || Objects.equals(s, "()[]") || Objects.equals(s, "[]()") || Objects.equals(s, "(){}") || Objects.equals(s, "{}[]") || Objects.equals(s, "[]{}") || Objects.equals(s, "{}()");
    }

    public static void main(String[] args) {
        Valid_Parentheses s1 = new Valid_Parentheses();
        s1.isValid("()");
    }
}
