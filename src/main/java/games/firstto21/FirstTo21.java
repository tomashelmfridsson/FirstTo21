package games.firstto21;
import java.util.Random;
import java.util.Scanner;


/*Spelets mål:
Var den första som når 26 eller mer!
Om spelaren når 26 före datorn, vinner spelaren.
Om datorn når 26 före spelaren, vinner datorn.

Regler:
Spelet börjar med talet 0.

Spelaren börjar först.

I varje omgång får spelaren välja att lägga till 1 eller 2.

Sedan gör datorn sitt drag (väljer slumpmässigt 1 eller 2).

Båda turas om tills summan når 26 eller mer.

Den som når eller passerar 26 först vinner spelet.

När spelet är slut, får spelaren frågan: "Vill du spela igen?"*/





public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random= new Random();
        String red = "\u001B[31m";
        String yellow = "\u001B[33m";
        String reset = "\u001B[0m";

        boolean playAgain = true;
        System.out.println("🎲 Welcome to the game! First one get 26 wins. 🎲");

        while (playAgain) {
            int currentNumber = 0;
            System.out.println("\nYou Start! 🚀");

            while (true) {
            int playerMove = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Write 1 or 2: ");
                if (scanner.hasNextInt()) {
                    playerMove = scanner.nextInt();
                    if (playerMove == 1 || playerMove == 2) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid choice, try again..");
                    }
                } else {
                    System.out.println("Invalid choice, try again..");
                    scanner.next();
                }
            }

            currentNumber += playerMove;
            System.out.println("You wrote: " + playerMove);
                System.out.println("Current total: " + yellow + currentNumber + reset);
                if (currentNumber >= 26) {
                    System.out.println(yellow + "🎉 Congratulations! You are the winner! 🎉" + reset);
                    break;
                }
                int computerMove = random.nextInt(2) + 1;
                currentNumber += computerMove;
                System.out.println("Computer wrote: " + computerMove);
                System.out.println("Current total: " + red + currentNumber + reset);

            if (currentNumber >= 26) {
                System.out.println(red + "💻 The Computer Wins! Better luck next time." + reset);
                break;
            }
            }
            scanner.nextLine(); // očisti unos nakon nextInt
            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            playAgain = answer.equals("yes") || answer.equals("y");


        }
        System.out.println("Thanks for playing! 👋");
        scanner.close();
    }

}