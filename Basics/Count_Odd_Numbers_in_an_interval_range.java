package com.Data_Structures_byprayush.Basics;
import java.util.Scanner;
//Given two non-negative integers low and high. Return the count of add numbers between low and high.[inclusive]
//Example : input-> low = 3 , high = 7
// output -> 3
//Explanation: The odd numbers between 3 and 7 are [3,5,7].
public class Count_Odd_Numbers_in_an_interval_range {
    //How to define one odd number.
    // Well if the remainder while dividing by 2 is not 0 then it's odd.
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);//inputting values.
        int low;
        int high;
        int count=0; //To keep count of odd numbers between low and high.
        low = scan.nextInt();
        high = scan.nextInt();

//   The code given below works just fine. But it's not optimized for bigger inputs like :  925006073, 995588062.
//        for (int i = low; i <= high ; i++) {
//            if(i%2!=0){
//                count++;
//            }
//        }
//        System.out.println(count);
        //If any of the low or high is odd...
        if( low % 2 != 0 || high % 2 != 0)
        {
           count = (high - low)/2 + 1;// If one is even other is odd or both odd then we will have to add halved [(high - low)/2] value with +1. for e.g.[7-3=4 4/2 = 2 + 1 = 3]
            System.out.println(count);
        }
        else {
            count = (high - low) / 2; // If there are two even number, even and odd numbers are divided evenly that is for e.g. 8-2 = 6, then 3 even and 3 odd.
            System.out.println(count);
        }
    }
}
