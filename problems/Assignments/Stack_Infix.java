package com.Data_Structures_byprayush.problems.Assignments;
//21BCE7864
//PRAYUSH GIRI
import java.util.Stack;
public class Stack_Infix {
    public static int precedence(char a){
        if(a == '^')
            return 2; //highest precedence
        else
            if(a=='*'||a=='/')
                return 1; //second-highest precedence
        else
            if(a=='+'||a=='-')
                return 0; //Lowest precedence
        return -1; //Not an operator
    }

    public static String InfixtoPostFix(String str)
    {
        Stack<Character> st1 = new Stack<>();
        StringBuilder ans = new StringBuilder(); //Storing are final answer
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char a = str.charAt(i);
            if(a>='0'&&a<='9')
                ans.append(a);//concatenating the character into the ans.
            else if(a=='(')
                st1.push('(');
            else if(a==')'){
                while(!st1.isEmpty()&&st1.peek()!='(')
                    ans.append(st1.pop()); //keep using pop until opening bracket is found.
                if(!st1.isEmpty())
                    st1.pop();
            }
            else{
                while(!st1.isEmpty() && precedence(st1.peek())>=precedence(a))
                    ans.append(st1.pop());//removing all higher precedence values.
                st1.push(a);
            }
        }
        while(!st1.isEmpty())
            ans.append(st1.pop());
        return ans.toString();
    }
    public static StringBuilder InfixtoPrefix(String expression)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();

        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (char c : charsExp) {
            if (precedence(c) > 0) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            } else if (c == ')') {
                char x = stack.pop();
                while (x != '(') {
                    result.append(x);
                    x = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {
                //character is neither operator nor “(“
                result.append(c);
            }
        }

        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        return result.reverse();
    }

    public static void main(String [] args)
    {
        //REG NUMBER : 21BCE7864
        String infix = "2+1-7*8/6+4";
        System.out.println("INFIX: "+ infix);
        System.out.println("PostFix: "+InfixtoPostFix(infix));
        System.out.println("PreFix: "+InfixtoPrefix(infix));
    }
}
