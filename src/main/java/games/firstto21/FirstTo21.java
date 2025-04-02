package games.firstto21;
import java.util.Scanner;

public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber = 0;
        String red = "\u001B[31m";
        System.out.println("Welcome to the game! First one get 21 wins.");
        System.out.println("You start!");

        while (true) {
            int playerMove = 0;
            while (playerMove != 1 && playerMove != 2) {
                System.out.print("Write 1 or 2: ");
                playerMove = scanner.nextInt();
                if (playerMove != 1 && playerMove != 2) {
                    System.out.println("Invalid choice, try again.");
                }
            }

            currentNumber += playerMove;
            System.out.println("You wrote: " + currentNumber);

            if (currentNumber >= 21) {
                System.out.println("Congratulations! You are the winner!");
                break;
            }

            int computerMove = ((currentNumber+1) % 3) == 0 ? 1 : 2;
            currentNumber += computerMove;
            System.out.println("Computer wrote: " + currentNumber);

            if (currentNumber >= 21) {
                System.out.println(red+"The Computer Wins! Better luck next time.");
                break;
            }
        }
        scanner.close();
    }
}