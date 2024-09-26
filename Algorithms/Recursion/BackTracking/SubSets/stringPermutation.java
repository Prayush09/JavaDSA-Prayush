package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking.SubSets;
import java.util.*;
public class stringPermutation {
    public static List<String> stri(String p, String unp){
        if(unp.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char a = unp.charAt(0);
        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i <= p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i);
            ans.addAll(stri(first+a+second,unp.substring(1)));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String>s = stri("","abc");
        System.out.println(s);
    }
}
