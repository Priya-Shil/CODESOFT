import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 10;

        int totalScore = 0;
        int roundsPlayed = 0;
        boolean playAgain;

        do {
            roundsPlayed++;
            int target = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.printf("Round %d: I'm thinking of a number between %d and %d.%n", 
                roundsPlayed, MIN, MAX);

            while (attemptsLeft > 0) {
                System.out.printf("You have %d attempt(s) left. Enter your guess: ", attemptsLeft);
                int guess = scanner.nextInt();

                if (guess == target) {
                    guessedCorrectly = true;
                    int pointsEarned = attemptsLeft; 
                    totalScore += pointsEarned;
                    System.out.printf("Correct! You earned %d point(s).%n", pointsEarned);
                    break;
                } else if (guess < target) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.printf("Out of attempts! The number was %d.%n", target);
            }

            System.out.printf("Total score so far: %d in %d round(s).%n", totalScore, roundsPlayed);

            System.out.print("Do you want to play another round? (Y/N): ");
            String response = scanner.next().trim().toUpperCase();
            playAgain = response.equals("Y");

            System.out.println();
        } while (playAgain);

        System.out.println("Game over!");
        System.out.printf("You played %d round(s) and scored %d point(s).%n", 
            roundsPlayed, totalScore);

        scanner.close();
    }
}
