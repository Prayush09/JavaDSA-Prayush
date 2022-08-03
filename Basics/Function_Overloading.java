package com.Data_Structures_byprayush.Basics;
//Two function of the same name, but different functionality.
public class Function_Overloading {
    public static void main(String[] args) {
        fun(50);
        fun("prayush giri");
    }
    static void fun(int a){
        System.out.println(a);
    }
    static void fun(String b){
        System.out.println(b);
    }
}
