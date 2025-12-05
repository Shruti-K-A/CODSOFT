import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;  // Score increases when player wins a round
        boolean playAgain = true;

        System.out.println("|== Welcome to the Number Guessing Game! ==|");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;  // 1–100
            int attemptsLeft = 7;  // limit attempts per round
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                
                // Check if the input given is a integer .
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); 
                    continue;
                }

                int guess = scanner.nextInt();
                attemptsLeft--;
                //The statement is displayed if the guess is correct.
                if (guess == numberToGuess) {
                    System.out.println("Kudos! You guessed the number!");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("Too high to the number to be guessed !");
                } else {
                    System.out.println("Too low to the number to be guessed!");
                }

                if (attemptsLeft > 0) {
                    System.out.println("The number of attempts left: " + attemptsLeft);
                }
            }
             //Runs if the player failed to guess within the given attempts
            if (!guessedCorrectly) {
                System.out.println("You are out of attempts!");
                System.out.println("The correct number was: " + numberToGuess);
            }

            // Ask player if they want to play another round
            System.out.print("\nDo you want to play another roundof guessing numbers? (yes/no): ");
            scanner.nextLine(); 
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n=== Game Over ===");
        System.out.println("Your final score: " + score);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
