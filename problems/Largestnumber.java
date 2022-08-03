package com.Data_Structures_byprayush.problems;
import java.util.Scanner;
public class Largestnumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter Three values: ");
        int a = in.nextInt();
        int b  = in.nextInt();
        int c = in.nextInt();

//        if(a>b && b>c)
//            System.out.println("The largest number is : " + a);
//        else
//            if(b>a &&a>c)
//                System.out.println("The largest number is : " + b);
//        else
//                System.out.println("The largest number is : " + c);
/*
        Kunal's code :

        int max = a;

        if (b > max)
        {
          max = b;
        }

        if (c > max)
        {
          max = c;
        }

        System.out.println(max);
*/
        //Now the most optimized way to solve this is to use math class.
        int max = Math.max(c,Math.max(a,b));
        System.out.println("The Largest value of the three is : "+max);
    }
}
