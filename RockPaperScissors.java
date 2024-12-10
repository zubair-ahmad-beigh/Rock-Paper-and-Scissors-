import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        // Welcome message
        System.out.println("Welcome to Rock, Paper, Scissors game!");

        // Loop to play 3 rounds
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nRound " + i + ":");
            System.out.println("Enter your move (rock, paper, or scissor): ");
            String playermove = sc.nextLine().toLowerCase();

            // Validate player input
            if (!playermove.equals("rock") && !playermove.equals("paper") && !playermove.equals("scissor")) {
                System.out.println("Invalid input! Please enter a valid move.");
                i--;  // Replay the current round in case of invalid input
                continue;
            }

            // Generate computer's move
            int computerRandomMove = random.nextInt(3);  // Generates 0, 1, or 2
            String computerMove = "";

            switch (computerRandomMove) {
                case 0:
                    computerMove = "rock";
                    break;
                case 1:
                    computerMove = "paper";
                    break;
                case 2:
                    computerMove = "scissor";
                    break;
            }

            // Display computer's move
            System.out.println("Computer chose: " + computerMove);

            // Determine the winner of the round
            if (playermove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if ((playermove.equals("rock") && computerMove.equals("scissor")) ||
                    (playermove.equals("scissor") && computerMove.equals("paper")) ||
                    (playermove.equals("paper") && computerMove.equals("rock"))) {
                System.out.println("You win this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }
        }

        // Display the final result after 3 rounds
        System.out.println("\nFinal Results:");
        System.out.println("Your score: " + playerScore);
        System.out.println("Computer score: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("Congratulations! You win the game.");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins the game. Better luck next time!");
        } else {
            System.out.println("It's a tie overall!");
        }

        sc.close();
    }
}

