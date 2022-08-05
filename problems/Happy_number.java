package com.Data_Structures_byprayush.problems;
import java.util.Scanner;
public class Happy_number {
    public boolean isHappy(int n)
    {
        int s= n ,f = n ;
        while(true){
            s = SumOfProduct(s);
            f = SumOfProduct(SumOfProduct(f));
            if (s == 1 ) {return true ;}
            else if (s == f ){
                return false ;
            }
        }

    }
    public int SumOfProduct (int n){
        int a,sum =0;
        while (n>0){
            a = n%10 ;
            sum = sum + (a*a);
            n = n/10 ;

        }
        return sum ;

    }




    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Happy_number h1 = new Happy_number();
        System.out.println(h1.isHappy(n));

    }
}
