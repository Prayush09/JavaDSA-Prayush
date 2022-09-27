package com.Data_Structures_byprayush;
import java.util.Scanner;

public class conditions
{
    public static void main(String[] args) {
        /*
        Syntax of if statements:
        if(boolean expression){
        //body
        } else
        {
        //body
        }
         */
        int income = 200000;
        if(income>100){
            income+= 200;
        }
        else
            income += 100;
        System.out.println(income);

        /*
        Loops

        1. for(initialisation; condition; increment/decrement)
        {
          //body
        }

        2. while (condition){
               //body
        }

        3. Do while:

        do{
        //body
        } while(condition);


     *Why to use do while: The code in this loop will atleast run once, that is first it compiles the do statement then it goes to check the condition,

     Code for do while:
         */
        int n = 1;
        do {
            System.out.println(n);
        }while(n!=1);

        //code for while loop
        int num = 1;
        while (num<=5)
        {
            System.out.println(num);
            num+= 1;
        }
        //You can use fori to create a intereated loop in intellij Idea
        //Code for for-loop:
        for (int i = 1; i <= 5; i++) {
            System.out.println("Roll number : "+ i);
        }

    }
}
