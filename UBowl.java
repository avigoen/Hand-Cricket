package PulzionGame;
import java.io.*;
public class UBowl extends start
{
    public static int userBalls=0;
    public UBowl()
    {
    }

    public UBowl(int noOfBalls)throws IOException
    {
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        int user=1, comp=0;
        userBalls=noOfBalls;
        double x;
        System.out.println("Start...");
        do
        {
            do
            {
                System.out.print("Enter your bowling value: ");
                user=Integer.parseInt(obj.readLine());
            }while(user>6 || user<0);
            do
            {
                x=(Math.random() * 10);
                if(x<=6)
                {
                    comp=(int)x;
                    break;
                }
            }
            while(comp<=6);
            System.out.println("Your number: "+user);
            System.out.println("My number: "+comp);
            if(user==comp)
            {
                System.out.println("I'm out!!");
                userBalls--;
                ballsRemaining--;
                cwickets++;
                break;
            }
            else
            {
                compTotalRuns+=comp;
                userBalls--;
                ballsRemaining--;
            }
            if(userBatFirst==1 && userTotalRuns<compTotalRuns)
            {
                userWon=0;
                break;
            }
            System.out.println();
        }
        while(user!=comp && userBalls>0);
        System.out.println("My score card: "+compTotalRuns+" runs.");
    }
}