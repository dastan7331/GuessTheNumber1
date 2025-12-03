package org.example;

import java.util.Random;
import java.util.Scanner;


public class GuessTheNumber {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("Welcome to the Guess the Number game.");

        while (true) {
            int maximumNumber = chooseDifficulty(sc);
            int hiddenNumber = rnd.nextInt(maximumNumber) + 1; // number from 1-100
            int attempts = 0;

            System.out.println("I have chosen a number between 1 and " + maximumNumber + ". Guess.");

            while (true) {
                System.out.print("Enter your guess: ");
                int guess = readInt(sc);
                attempts++;

                if (guess < hiddenNumber) {
                    System.out.println("its too small");
                } else if (guess > hiddenNumber) {
                    System.out.println("its too big");
                } else {
                    System.out.println("You guessed it, congrats");
                    System.out.println("Attempts you used: " + attempts);
                    break;
                }
            }
            System.out.println("Do you want to play again? (yes/no): ");
            String answer = sc.next().toLowerCase();
            sc.nextLine(); //clear input buffer

            if (!answer.equals("y")) {
                System.out.println("Thanks for playing. Goodbye ");
                break;
            }
        }
    }
    public static  int chooseDifficulty(Scanner sc ) {
        System.out.println("Choose difficulty of level: ");
        System.out.println("1. Easy (1-50)");
        System.out.println("2. Medium (1-100)");
        System.out.println("3. Hard (1-500)");

        while (true) {
            int choice = readInt(sc);
            switch (choice) {
                case 1: return 50;
                case 2: return 100;
                case 3: return 500;
                default:System.out.print("Incorrect choice, try again: ");

            }
        }
    }
    public static int readInt(Scanner sc) {
        while (true) {
            String input = sc.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input. Please enter a number: ");
            }
        }
    }
}
