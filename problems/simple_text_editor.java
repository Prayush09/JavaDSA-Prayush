package com.Data_Structures_byprayush.problems;
import java.util.Scanner;
import java.util.Stack;
/*
1. adding a character to stack
2. deleting a character from stack
3. returning the character at a particular index
4. reverting the last executed command.
 */

class customStack{


        static String newString;
        static String lastString;


        public static String append(String addString, Stack<String> stack){
            //extracting the string that was appended last to the stack.
            lastString = stack.size() > 0 ? stack.peek() : "";
            newString = lastString + addString;
            return newString;
        }

        public static String delete(Stack<String> stack){
             lastString = stack.peek();
             //deleting the last element from the string.
             newString = lastString.substring(0,lastString.length()-1);
             return newString;
        }

        public static String get(Stack<String> stack, int index)
        {
            String character="";
            if(!stack.isEmpty())
            {
                lastString = stack.peek();
                character = String.valueOf(lastString.charAt(index));
            }
            return character;
        }
}

public class simple_text_editor extends customStack {
    public static void main(String[] args) {
        //tools
        Scanner scan = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        long testCase = scan.nextInt();


        int command;

        while (testCase --> 0){
            //input the command
            command =  scan.nextInt();
            switch(command)
            {
                case 1:
                    String inputString = scan.next();
                    stack.push(append(inputString, stack));
                    break;
                case 2:
                    stack.push(delete(stack));
                    break;
                case 3:
                    String input = stack.peek();
                    int index = input.length()-1;
                    System.out.println(get(stack,index));
                    break;
                case 4:
                    stack.pop();
                    break;
            }
        }


    }
}
