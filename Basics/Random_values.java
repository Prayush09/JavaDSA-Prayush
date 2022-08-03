package com.Data_Structures_byprayush.Basics;
import java.util.Random;
public class Random_values {
    public static void main(String[] args) {
        Random r = new Random();
        //pseudo random numbers, and not true random numbers.
        int x = r.nextInt(6)+1;
        //we can limit the scale of the random number called bound., to get number from 1 to 6 we can +1. // generates a random number.
        double y = r.nextDouble(9.5)+1.9;
        boolean z = r.nextBoolean();
        System.out.println(Math.abs(x));//to print only positive values i am using,
        //math function absolute.
        System.out.println(y);
        System.out.println(z);
    }
}
