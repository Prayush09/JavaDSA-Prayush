package com.Data_Structures_byprayush.problems;

import java.util.*;
public class Functions_SUM {
    Scanner scan = new Scanner (System.in);
    public static void main(String[] args) {

        Functions_SUM s1 = new Functions_SUM();
       s1.sum();

    }

    void sum() {
        //Body of the function.
        System.out.println("Enter number 1");
        int num1 = scan.nextInt();
        System.out.println("Enter number 2");
        int num2 = scan.nextInt();
        int sum = num1 + num2;
        System.out.println(sum); //A return statement is a must in a function.
    }
}

