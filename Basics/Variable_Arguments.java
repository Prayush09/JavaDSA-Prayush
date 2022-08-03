package com.Data_Structures_byprayush.Basics;
import java.util.Arrays;
public class Variable_Arguments {
        public static void main(String [] args){
            fun(93,3094,0,3331,59594935,606);
            //No limit to how many arguments we can save.
            multiple(10,20,"Prayush","Nimish","Aarush");
        }

        static void fun(int ...v){ //int ...v is a variable argument, allows us to take as many arguments as we need. Automatically stores it in an array.
            System.out.println(Arrays.toString(v));
        }//void - A return type.
    static void multiple(int a, int b, String ...s){
        System.out.println(a+b+" :The sum");
        System.out.println(Arrays.toString(s));//The variable argument will make the string arguments into a string so when we need to print those string we use Arrays.toString() method.
    }
}
