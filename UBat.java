package PulzionGame;
import java.io.*;
public class UBat extends start
{
    public static int compBalls=0;
    public UBat()
    {
    }

    public UBat(int noOfBalls)throws IOException
    {
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        int user=1, comp=0;
        compBalls=noOfBalls;
        double x;
        System.out.println("Start...");
        do
        {
            do
            {
                System.out.print("Your turn: ");
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
                System.out.println("You are out!!");
                compBalls--;
                ballsRemaining--;
                uwickets++;
                break;
            }
            else
            {
                userTotalRuns+=user;
                compBalls--;
                ballsRemaining--;
            }
            if(userBatFirst==0 && userTotalRuns>compTotalRuns)
            {
                userWon=1;
                break;
            }
            System.out.println();
        }
        while(user!=comp && compBalls>0);
        System.out.println("Your score card: "+userTotalRuns+" runs.");
    }
}
