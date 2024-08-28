import java.util.InputMismatchException;
import java.util.Scanner;

//code soft Task1 : Number Game

public class NumberGame {
    public static void main(String[] args) {

        int maxAttempts = 10; //limits the number of attempts
        boolean playAgain=true;
        int totalRoundsWon=0;

        Scanner sc = new Scanner(System.in);

        while(playAgain){

            int randomNumber = (int)(Math.random() * 100) + 1; // Generates a number between 1 and 100
            boolean guessed = false;
            int round = 1;

            while(!guessed && round <= maxAttempts) {

                System.out.print("Enter number (attempt " + round + " of " + maxAttempts + "):");
                int userNumber = 0;

                try {
                    userNumber = sc.nextInt();
                    //user input number range validation
                    if(userNumber <1 || userNumber >100){
                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextInt();
                    continue;
                }

                if(userNumber > randomNumber) {
                    System.out.println("Guessed number is too High.");
                } else if(userNumber < randomNumber) {
                    System.out.println("Guessed number is too Low.");
                } else {
                    System.out.println("Guessed number is correct!");
                    guessed = true;
                    totalRoundsWon++;
                }
                round++;
            }

            if(!guessed) {
                System.out.println("You've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            System.out.println("User Score: " + (guessed ? round - 1 : maxAttempts));

            System.out.println("Would you like to play again? (Type 'yes' to play again or 'no' to exit):");
            String userInput = sc.next().trim().toLowerCase();

            if (userInput.equals("no")) {
                playAgain = false;
                System.out.println("---------- Thank you for playing! Your total rounds won -----------> " + totalRoundsWon);
            } else if (!userInput.equals("yes")) {
                System.out.println("Invalid response. Exiting the game.");
                playAgain = false;
            }
        }
        sc.close();
    }
}
