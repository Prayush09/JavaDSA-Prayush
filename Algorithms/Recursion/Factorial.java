package com.Data_Structures_byprayush.Algorithms.Recursion;

class Main{
    public static long factorial(int n){
        if(n == 0 || n == 1)
            return 1;
        return n * factorial(n-1);
    }

    public static void main(String[] args) {

        System.out.println(factorial(9));
    }
}
