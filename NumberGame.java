import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int min = 1;
        int max = 100;
        int target = rand.nextInt(max - min + 1) + min; // random number between 1 and 100
        int attempts = 0;
        int guess = -1;

        System.out.println("I'm thinking of a number between " + min + " and " + max + ".");
        System.out.println("Try to guess it!");

        while (guess != target) {
            System.out.print("Enter your guess: ");
            if (!sc.hasNextInt()) {            // handle non-integer input
                sc.next();                     // discard invalid token
                System.out.println("Please enter a valid integer.");
                continue;
            }

            guess = sc.nextInt();
            attempts++;

            if (guess < target) {
                System.out.println("Too low.");
            } else if (guess > target) {
                System.out.println("Too high.");
            } else {
                System.out.println("Correct! You guessed the number in " + attempts + " attempt" + (attempts > 1 ? "s." : "."));
            }
        }

        sc.close();
    }
}
