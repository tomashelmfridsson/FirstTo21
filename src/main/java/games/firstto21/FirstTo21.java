package games.firstto21;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FirstTo21 {
    enum DIFFICULTY{
        EASY,
        MEDIUM,
        HARD,
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber = 0;
        DIFFICULTY currentDiff;
        String red = "\u001B[31m";
        System.out.println("Välkommen till spelet! Den som säger 21 vinner.");
        System.out.println("Välj svårighetsgrad genom att skriva Easy, Medium eller Hard");

        switch(scanner.nextLine().toLowerCase())
        {
            case "easy":
                currentDiff = DIFFICULTY.EASY;
                break;
            case "medium":
                currentDiff = DIFFICULTY.MEDIUM;
                break;
            case "hard":
                currentDiff = DIFFICULTY.HARD;
                break;
            default:
                currentDiff = DIFFICULTY.MEDIUM;
                System.out.println("Ingen svårighetsgrad vald så vi går med Medium");
                break;
        }
        System.out.println("Då kan spelet börja.");
        System.out.println("Du börjar!");

        while (true) {
            int playerMove = 0;
            while (playerMove != 1 && playerMove != 2) {
                System.out.print("Säg 1 eller 2: ");
                try{
                    playerMove = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Ogiltigt val, försök igen.");
                    continue;
                }

                if (playerMove != 1 && playerMove != 2) {
                    System.out.println("Ogiltigt val, försök igen.");
                }
            }

            currentNumber += playerMove;
            System.out.println("Du sa: " + currentNumber);

            if (currentNumber >= 21) {
                System.out.println("Grattis! Du vinner!");
                break;
            }

            int computerMove;
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            switch (currentDiff)
            {
                case DIFFICULTY.EASY:
                    if(randomNum > 70)
                    {
                        computerMove = ((currentNumber+1) % 3) == 0 ? 1 : 2;
                    }else {
                        computerMove = ((currentNumber+1) % 3) == 0 ? 2 : 1;
                    }
                    break;
                case DIFFICULTY.HARD:
                    if(randomNum > 30)
                    {
                        computerMove = ((currentNumber+1) % 3) == 0 ? 1 : 2;
                    }else {
                        computerMove = ((currentNumber+1) % 3) == 0 ? 2 : 1;
                    }
                    break;
                default:

                    if(randomNum > 50)
                    {
                        computerMove = ((currentNumber+1) % 3) == 0 ? 1 : 2;
                    }else {
                        computerMove = ((currentNumber+1) % 3) == 0 ? 2 : 1;
                    }
                    break;
            }


            currentNumber += computerMove;
            System.out.println("Datorn säger: " + currentNumber);

            if (currentNumber >= 21) {
                System.out.println(red+"Datorn vinner! Bättre lycka nästa gång.");
                break;
            }
        }
        scanner.close();
    }
}