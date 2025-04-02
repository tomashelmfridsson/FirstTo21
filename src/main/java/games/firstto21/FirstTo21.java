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
        String yellow = "\u001B[33m";
        System.out.println("🎲 Welcome to the game! First one get 26 wins. 🎲");
        System.out.println("Choose difficulty by typing: Easy, Medium eller Hard");

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
                System.out.println("No difficulty picked so Medium is chosen by default");
                break;
        }
        System.out.println("Then the game can begin");
        System.out.println("You Start! 🚀");

        while (true) {
            int playerMove = 0;
            while (playerMove != 1 && playerMove != 2) {
                System.out.print("Choose 1 or 2: ");
                try{
                    playerMove = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid choice, try again..");
                    continue;
                }

                if (playerMove != 1 && playerMove != 2) {
                    System.out.println("Invalid choice, try again..");
                }
            }

            currentNumber += playerMove;
            System.out.println("You wrote: " + currentNumber);


            if (currentNumber >= 26) {
                System.out.println(yellow+"Congratulations! You are the winner!");
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
            System.out.println("Computer wrote: " + currentNumber);

            if (currentNumber >= 26) {
                System.out.println(red +"The Computer Wins! Better luck next time.");
                break;
            }
        }
        scanner.close();
    }
}