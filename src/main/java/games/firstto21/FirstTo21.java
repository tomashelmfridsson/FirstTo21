package games.firstto21;
import java.util.Scanner;

public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber = 0;
        String red = "\u001B[31m";
        String yellow ="\u001B[33m";
        System.out.println("Välkommen till spelet! Den som säger 26 vinner.");
        System.out.println("Du börjar!");

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

            int computerMove = ((currentNumber+1) % 3) == 0 ? 1 : 2;
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