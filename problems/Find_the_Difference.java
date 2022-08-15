package com.Data_Structures_byprayush.problems;
import java.util.Scanner;
public class Find_the_Difference {
    public char findTheDifference(String s, String t){
        char a = 0;
        for(char cs : s.toCharArray())
            a = (char) (a^cs);
        for(char ct : t.toCharArray())
            a = (char) (a^ct);
        return a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Find_the_Difference obj1 = new Find_the_Difference();
        String ab1 = scan.next();
        String ab2 = scan.next();
        System.out.println(obj1.findTheDifference(ab1,ab2));
    }
}
