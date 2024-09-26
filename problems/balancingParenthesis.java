package com.Data_Structures_byprayush.problems;

import java.util.*;

public class balancingParenthesis {
    public static  boolean isValid(String s){
        int balance = 0;
        for(char c : s.toCharArray()) {
            if (c == '(')
                balance++;
            else if(c == ')')
                balance--;

            if(balance < 0)
                    return false;
        }
        return balance == 0;
    }

    public static List<String> balanceP(String s){
        List<String> ans = new ArrayList<>();
        if(s == null) return ans;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(s);
        visited.add(s);
        boolean foundAns = false;

        while(!q.isEmpty()){
            String current = q.poll();

            if(isValid(current)){
                ans.add(current);
                foundAns = true;
            }

            if(foundAns) continue;

            for(int i = 0; i < current.length(); i++){
                if(current.charAt(i) != '(' && current.charAt(i) != ')') continue;

                String next = current.substring(0, i) + current.substring(i + 1);
                if(!visited.contains(next)){
                    q.offer(next);
                    visited.add(next);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String input = "(s)())()";
        List<String> result = balanceP(input);

        for (String str : result) {
            System.out.print(str+" ");
        }
    }
}
