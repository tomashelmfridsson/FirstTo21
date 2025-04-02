package games.firstto21;
import java.util.Random;
import java.util.Scanner;

public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber = 0;
        Random random= new Random();
        String red = "\u001B[31m";
        String yellow = "\u001B[33m";
        System.out.println("🎲 Welcome to the game! First one get 26 wins. 🎲");
        System.out.println("Den som säger 26 vinner.");
        System.out.println("You Start! 🚀");

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


            if (currentNumber >= 26) {
                System.out.println(yellow+"Congratulations! You are the winner!");
                break;
            }

            int computerMove = random.nextInt(2) + 1;
            currentNumber += computerMove;
            System.out.println("Computer wrote: " + currentNumber);

            if (currentNumber >= 26) {
                System.out.println(red +"The Computer Wins! Better luck next time.");
                break;
            }
        }
        scanner.close();
    }
}