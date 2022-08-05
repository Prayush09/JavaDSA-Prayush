package com.Data_Structures_byprayush.problems;

public class Goal_Parser_Interpretation {
    public String Goal_Parser(String command){
        StringBuilder sb = new StringBuilder();
        int length = command.length();
        for (int i = 0; i < length; i++) {
            if(command.charAt(i)=='G'){
                sb.append("G");
            }
            else if(command.charAt(i)=='('){
                if(command.charAt(i+1)==')')
                    sb.append("o");
                else
                    sb.append("al");
            }
        }
       return sb.toString();
    }

    public static void main(String [] args){
        Goal_Parser_Interpretation g1 = new Goal_Parser_Interpretation();
        System.out.println(g1.Goal_Parser("(al)G(al)()()G"));

    }

}
