package com.Data_Structures_byprayush.problems;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;


/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        // your code goes here
        for(int i = 0 ; i<t ; i++)
        {
            int temp=0;
            int n,m;
            n=scan.nextInt();
            m=scan.nextInt();
            while(n>0)
            {
                temp += m;
                n--;
            }
            System.out.println(temp);
        }
    }
}
