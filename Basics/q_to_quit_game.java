package com.Data_Structures_byprayush.Basics;
import java.util.Scanner;
public class q_to_quit_game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tries = 10;
        System.out.println("You are playing a game, " +
                "If you want to quit you will do exactly" +
                " as i say...");
        System.out.println("PRESS");
        System.out.println("Q");
        System.out.println("or");
        System.out.println("q");
        System.out.println("to quit.");
        System.out.println("Enter The Character: ");
        while(tries>0){
            String word  = scan.next();
            if(word.equals("q")||word.equals("Q")){
                System.out.println("You have won.");
                break;
            }else
                System.out.println("try again you dumbo...");
            --tries;
            if(tries==0)
                System.out.println("You have exhausted your tries.");
        }
    }
}
