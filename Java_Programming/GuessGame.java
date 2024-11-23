import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int roundNumber = 1;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\n--- Round " + roundNumber + " ---");
            Random random = new Random();
            int R_Number = random.nextInt(100) + 1;
            int attempts = 5;
            boolean roundWon = false;

            while (attempts > 0) {
                System.out.print("Enter your guess (1-100). Attempts left: " + attempts + ": ");

                int guess = 0;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                if (guess < 1 || guess > 100) {
                    System.out.println("Please guess a number within the range 1 to 100.");
                    continue;
                }

                if (guess < R_Number) {
                    System.out.println("Too low!");
                } else if (guess > R_Number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundWon = true;
                    score += attempts;
                    break;
                }

                attempts--;
            }

            if (!roundWon) {
                System.out.println("Out of attempts! The correct number was " + R_Number + ".");
            }

            System.out.print("Do you want to play another round? (y/n): ");
            String playAgainInput = scanner.nextLine().trim().toLowerCase();
            playAgain = playAgainInput.equals("y");

            roundNumber++;
        }

        System.out.println("\nGame Over! Your final score: " + score + " points.");
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}