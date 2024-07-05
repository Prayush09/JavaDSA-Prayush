package com.Data_Structures_byprayush.problems;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
public class SkipACharacter{

    public static String avoidCharacter(String s, Character a){
        if(s.isEmpty()){
            return "";
        }
        char check = s.charAt(0);
        if(check != a){
            return check + avoidCharacter(s.substring(1),a);
        }else{
            return avoidCharacter(s.substring(1),a);
        }
    }

    public static String avoidString(String input, String avoid){
        if(input.isEmpty())
            return "";
        char first = input.charAt(0);
        if(!input.startsWith(avoid)){
            return first + avoidString(input.substring(1),avoid);
        }else{
            return avoidString(input.substring(avoid.length()),avoid);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("enter string: ");
        String s = scan.nextLine();
        //System.out.print("enter character to remove: ");
        //Character target = scan.next().charAt(0);
        //System.out.println(avoidCharacter(s,target));
        String avoid = scan.next();
        System.out.println(avoidString(s,avoid));
    }
}