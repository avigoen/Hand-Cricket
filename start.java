package PulzionGame;
import java.io.*;
public class start
{

    public static int userBatFirst, compBatFirst, userTotalRuns, compTotalRuns;
    public static int userWon=9, cwickets=0, uwickets=0;;
    public static int ballsRemaining=1;

    public static void main(String args[])throws IOException
    {
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("############################################################");
        System.out.println("       +-+-+-+-+-+-+-+- INSTRUCTIONS -+-+-+-+-+-+-+-+");
        System.out.println("#  1. User enters the cricket format he wants to play.     #");
        System.out.println("#  2. User then enters the number of wickets he wishes     #");
        System.out.println("#  to have in his team                                     #");
        System.out.println("#  3. During the course of the game, the user can only     #");
        System.out.println("#  enter values from 0 to 6 as the valid entries           #");
        System.out.println("#  Any other values will NOT be accepted and the user      #");
        System.out.println("#  will be again prompted to enter again                   #");
        System.out.println("#  The game ends when either the user or the computer AI   #");
        System.out.println("#  gather more runs than the other or scalp the other's    #");
        System.out.println("#  wickets before they gather their target runs.           #");
        System.out.println("############################################################");
        try{Thread.sleep(3500);}
        catch (InterruptedException ie){System.out.println(ie.getMessage());}
        
        
        System.out.println("Lets Begin...");
        try{Thread.sleep(1000);}
        catch (InterruptedException ie){System.out.println(ie.getMessage());}

        System.out.println("Enter the format type you want to play...\n1 -> 1 Overs Format\n2 -> 2 Overs Format\n3 -> 3 Overs Format");
        int noOfBalls=Integer.parseInt(obj.readLine());
        noOfBalls*=6;
        int noOfBalls1=noOfBalls, noOfBalls2=noOfBalls;

        System.out.println("Number of Wickets each...");
        int wickets=Integer.parseInt(obj.readLine());

        System.out.println("Toss...");
        try{Thread.sleep(2000);}
        catch (InterruptedException ie){System.out.println(ie.getMessage());}
        double toss=(Math.random());

        int uschoice=9, cchoice=10;
        if(toss%2!=0)
        {
            System.out.println("Choose: 1-Batting OR 2-Bowling");
            uschoice=Integer.parseInt(obj.readLine());
        }
        else
        {
            cchoice=(int)(Math.random());
            if(cchoice<5)
            {
                System.out.println("I'll Bat First.");
                uschoice=2;
            }
            else
            {
                System.out.println("I'll Bowl First.");
                uschoice=1;
            }
        }
        ballsRemaining=noOfBalls;
        UBat uba=new UBat();
        UBowl ubo=new UBowl();
        if(uschoice==1)
        {
            System.out.println("-------------------------------");
            System.out.println("        YOUR BATTING");
            System.out.println("-------------------------------");
            userBatFirst=1;     compBatFirst=0;
            ballsRemaining=noOfBalls;
            for(int i=0;i<wickets && ballsRemaining>0;i++)
            {
                System.out.println("\nWicket #"+(i+1));
                uba=new UBat(ballsRemaining);
                /*noOfBalls1-=uba.compBalls;
                ballsRemaining=noOfBalls1;*/
                //userTotalRuns+=uba.userRuns;
            }
            System.out.println("-------------------------------");
            System.out.println("        MY BATTING");
            System.out.println("-------------------------------");
            ballsRemaining=noOfBalls;
            for(int i=0;i<wickets && ballsRemaining>0;i++)
            {
                System.out.println("\nWicket #"+(i+1));
                ubo=new UBowl(ballsRemaining);
                if(userWon==0)
                {
                    break;
                }
                /*noOfBalls2-=ubo.userBalls;
                ballsRemaining=noOfBalls2;*/
                //compTotalRuns+=ubo.compRuns;
            }
        }
        else if(uschoice==2)
        {
            System.out.println("-------------------------------");
            System.out.println("        MY BATTING");
            System.out.println("-------------------------------");
            userBatFirst=0;     compBatFirst=1;
            ballsRemaining=noOfBalls;
            for(int i=0;i<wickets && ballsRemaining>0;i++)
            {
                System.out.println("\nWicket #"+(i+1));
                ubo=new UBowl(ballsRemaining);
                /*noOfBalls2-=ubo.userBalls;
                ballsRemaining=noOfBalls2;*/
                //compTotalRuns+=ubo.compRuns;
            }
            System.out.println("-------------------------------");
            System.out.println("        YOUR BATTING");
            System.out.println("-------------------------------");
            ballsRemaining=noOfBalls;
            for(int i=0;i<wickets && ballsRemaining>0;i++)
            {
                System.out.println("\nWicket #"+(i+1));
                uba=new UBat(ballsRemaining);
                if(userWon==1)
                {
                    break;
                }
                /*noOfBalls1-=uba.compBalls;
                ballsRemaining=noOfBalls1;*/
                //userTotalRuns+=uba.userRuns;
            }
        }

        System.out.println("-------------------------------");
        System.out.println("\nYour total runs: "+userTotalRuns+" with the loss of "+uwickets+" wickets.");
        System.out.println("My total runs: "+compTotalRuns+" with the loss of "+cwickets+" wickets.");
        if(userTotalRuns<=compTotalRuns)
        {
            System.out.println("I won!");
        }
        else if(userTotalRuns>=compTotalRuns)
        {
            System.out.println("You won!");
        }
        else if(userTotalRuns==compTotalRuns)
        {
                System.out.println("It's a draw!");
        }
    }
}