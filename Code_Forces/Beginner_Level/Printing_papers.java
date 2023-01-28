import java.util.Scanner;
public class operation{
    public static void main(String[] args)
    {
        //Supplier sells n papers a week
        Scanner scan = new Scanner(System.in);
        //Michael can purchase in power of two.
        int input = scan.nextInt();
        int power=0;
        for(int i = 0; i < input ; i++)
        {
            power = (int)Math.pow(2,i);
            if(power>input)
            {
                power=(int)Math.pow(2,i-1);
                break;
            }
        }
        System.out.println(power);
    }
}