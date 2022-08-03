package com.Data_Structures_byprayush.Basics;
import javax.swing.JOptionPane;

public class Graphical_User_Interface {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Please enter your name: ");
        //parseInt - A method to convert string to integer using the wrapper class Integer.parseInt();
        int age = Integer.parseInt(JOptionPane.showInputDialog("Please enter your age: "));
        int rate = Integer.parseInt(JOptionPane.showInputDialog("On a rate of 1 to 10 you would give this a : "));
        switch(rate){
            case 1: JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                    JOptionPane.showMessageDialog(null,"You have only given 1 as a rating. *(ㆆ_ㆆ)*");
                    break;
            case 2:JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                JOptionPane.showMessageDialog(null,"You have only given 2 as a rating. *(ㆆ_ㆆ)*");
                break;
            case 3: JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                JOptionPane.showMessageDialog(null,"You have only given 3 as a rating. *(ㆆ_ㆆ)*");
                break;
            case 4: JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                JOptionPane.showMessageDialog(null,"You have only given 4 as a rating. *(ㆆ_ㆆ)*");
                break;
            case 5: JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                JOptionPane.showMessageDialog(null,"You have only given 5 as a rating. *a bit better but i am sad.  ͡❛ ͜ʖ ͡❛ *");
                break;
            case 6: JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                JOptionPane.showMessageDialog(null,"You have given 6 as a rating. *it was an okay experience for you(-0:0-).  ͡❛ ͜ʖ ͡❛ ");
                break;
            case 7:
                JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                JOptionPane.showMessageDialog(null,"You have given 7 as a rating. *it was an okay experience for you(-0:0-).  ͡❛ ͜ʖ ͡❛ ");
                break;
            case 8:
                JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                JOptionPane.showMessageDialog(null,"You have given 8 as a rating. *it was a good experience for you. (っ＾▿＾)۶٩(˘◡˘ ) ");
                break;
            case 9:
                JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                JOptionPane.showMessageDialog(null,"You have given 9 as a rating. *it was a great experience for you.(͠≖ ͜ʖ͠≖)");
                break;
            case 10:
                JOptionPane.showMessageDialog(null,"Hello "+name+ "\nThe age you have inputted is: "+age+" Years");
                JOptionPane.showMessageDialog(null,"You have given 10 as a rating. *it was an amazing experience for you. Glad to hear it.☜(ˆ▿ˆc)");
                break;
        }
    }

}

