import java.util.Scanner;
import java.lang.Math;

public class Game{
    public static void main(String[] args){

        Scanner input= new Scanner(System.in);
        
        System.out.println("\nThis is a Guessing Game\n");
        System.out.println("You have to guess which number I(Computer) am thinking.\nYou will have total 100 points at start.\nFor each wrong guess, 20 points will be deducted.\n\nCan you guess that number??(yes/no): ");
        String play= input.next().toLowerCase();
        
        if(play.equals("yes")){
            System.out.println("\nLets Play!!\n");

            int ans;
            int n= 5;
            boolean flag;
            String again; 
            int score;
            int attempts;
            int round= 0;

            System.out.println("I am thinking a number between 1 to 100.\nYou have " + n + " attempts, Good Luck!!\n");
        
            do{
                ans= (int)(Math.random() * 100) + 1;
                n= 5;
                again= "yes";
                score= 100;
                attempts= 0;
                round++;
                flag= false;
                System.out.println("Round " + round + " starts...");

            while(n>0){
                attempts++;
                System.out.println("Enter your guess: ");
                int guess= input.nextInt();

                if(guess==ans){
                    flag= true;
                    System.out.println("Your guess is correct, You Won the Game!!\n\nYour score is: " + score + " points\nNo. of attempts used: " + attempts + "\n");
                    break;
                }

                else if(guess < ans){

                    if(guess<0 || guess > 100){
                        System.out.println("Bad Input. Guess the number in between 0 to 100 only.\nYou have " + (n-1) + " attempts remaining.\n");
                    }

                    else{
                        System.out.println("Your guess is low.\nYou have "+ (n-1) + " attempts remaining.\n");
                    }

                    score= score - 20;
                }

                else{

                    if(guess<0 || guess > 100){
                        System.out.println("Bad Input. Guess the number in between 0 to 100 only.\nYou have " + (n-1) + " attempts remaining.\n");
                    }

                    else{
                        System.out.println("Your guess is high.\nYou have "+ (n-1) + " attempts remaining.\n");
                    }

                    score= score - 20;
                }

                n--;
            }

            if(flag==false && n==0){
                System.out.println("You used all your attempts.\nThe Correct Number is: " + ans + "\nYour score is: " + score + " points\n\nYou Lost!!\n");
            }

            System.out.println("Do you wanna play again??(yes/no): ");
            again= input.next().toLowerCase();
            System.out.print("\n");

            } while(again.equals("yes"));
               
        }
        
    }
}