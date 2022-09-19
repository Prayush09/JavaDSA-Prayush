package com.Data_Structures_byprayush.problems;
import java.util.Stack;
public class Valid_Parentheses {
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] a = s.toCharArray();
        //To do this using strings you can use for(String string : s.split("")) -> where s is the string in the parameter of the function
        for (char c : a) {
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            if(c==')')
            {
                if(!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
                else
                    return false;
            }
            if(c=='}')
            {
                if(!stack.isEmpty()&&stack.peek()=='{')
                    stack.pop();
                else
                    return false;
            }
            if(c==']')
            {
                if(!stack.isEmpty()&&stack.peek()=='[')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Valid_Parentheses s1 = new Valid_Parentheses();
        System.out.println(s1.isValid("(){}[]{}[]()"));
    }
}
