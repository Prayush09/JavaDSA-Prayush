package com.Data_Structures_byprayush.Algorithms.Recursion;
//Sum of the two numbers that preceded it.
public class Fibonacci_Series {

    private static final int MAX_Nums = 30;

    private static long[] fibCache = new long[MAX_Nums];

    public static long fibonacci(int n){
        //what will be the base case for fibonacci.
        //When we have only 0 or 1
        // then 0+0 = 0 and 1+0 = 1
        //=> if 0 or 1 is the input return that number.
        if(n == 0 || n == 1)
            return n;
        //if we found previous computed result in cache then just return.
        else if(fibCache[n] != 0)
            return fibCache[n];
        //recursive part is that we add the previous two numbers:
        else{
            long result = fibonacci(n-1) + fibonacci(n-2);
            fibCache[n] = result;
            return fibCache[n];
        }
    }

    //Since the recursion for a huge input is so intense
    //we have to introduce the concept of memoization
    /*
    In computing, memoization or memoisation is an optimization technique
    used primarily to speed up computer programs by storing
    the results of expensive function calls and returning the cached
    result when the same inputs occur again
     */


    public static void main(String[] args) {
        //to print the fibonacci series till 30,
        //change MAX_Nums to get more number.
        //Used memoization and recursion.
        for (int i = 0; i < MAX_Nums; i++) {
            System.out.println(fibonacci(i)+", ");
        }
        System.out.println("....And it keeps on going ;-)");
    }
}
