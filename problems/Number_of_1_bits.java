package com.Data_Structures_byprayush.problems;

import java.util.Scanner;

public class Number_of_1_bits {
    static int[] BitsSetTable256 = new int[256];
    public static void initialize(){
        //Making the bit set table.
        BitsSetTable256 [0] = 0;
        for (int i = 0; i < 256; i++) {
            BitsSetTable256 [i] = (i&1) + BitsSetTable256[i/2];
        }
    }
    public static int  hammingweight(int n){
return (BitsSetTable256[n & 0xff]
        + BitsSetTable256[(n >> 8) & 0xff]
        + BitsSetTable256[(n >> 16) & 0xff]
        + BitsSetTable256[n >> 24]);
    }

    public static void main(String[] args)
    {

        // Initialise the lookup table
        initialize();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.print(hammingweight(n));
    }
}
