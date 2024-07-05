package com.Data_Structures_byprayush.Algorithms.Recursion;

public class Sum_of_NaturalNo {
    public static int SumNaturalNo(int number){
        //base case
        if(number <= 1)
            return number;
        return number + SumNaturalNo(number-1);
    }
    public static void main(String[] args)
    {
        int result = SumNaturalNo(10);
        System.out.println(result);
    }
}
//MY METHOD:

// public static int SumNaturalNo(int number, int result){
//     //base case
//     if(number == 0)
//         return result;
//     result += number;
//     return SumNaturalNo(number-1,result);
// }