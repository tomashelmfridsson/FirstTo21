package games.firstto21;
import java.util.Random;
import java.util.Scanner;

public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber = 0;
        Random random= new Random();
        String red = "\u001B[31m";
        System.out.println("🎲 Välkommen till 'Först till 26'! 🎲");
        System.out.println("Den som säger 26 vinner.");
        System.out.println("Du börjar! 🚀");

        while (true) {
            int playerMove = 0;
            while (playerMove != 1 && playerMove != 2) {
                System.out.print("Säg 1 eller 2: ");
                playerMove = scanner.nextInt();
                if (playerMove != 1 && playerMove != 2) {
                    System.out.println("Ogiltigt val, försök igen.");
                }
            }

            currentNumber += playerMove;
            System.out.println("Du sa: " + currentNumber);

            if (currentNumber >= 26) {
                System.out.println(yellow+"Grattis! Du vinner!");
                break;
            }

            int computerMove = random.nextInt(2) + 1;
            currentNumber += computerMove;
            System.out.println("Datorn säger: " + currentNumber);

            if (currentNumber >= 26) {
                System.out.println(red +"Datorn vinner! Bättre lycka nästa gång.");
                break;
            }
        }
        scanner.close();
    }
}