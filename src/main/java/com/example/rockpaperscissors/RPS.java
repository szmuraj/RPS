package com.example.rockpaperscissors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RPS {
    static int computerScore = 0;
    static int playerScore = 0;
    static int draw = 0;
    public static void main(String[] args) {
        final String youPlayAs = "You play as ";
        final String computerPlayAs = "Computer play as ";
        final String confirmation = "Are you sure y/n\n";
        final String computerWin = "This time computer wins do you wanna play one more? y/n";
        final String playerWin = "This time player wins do you wanna play once more? y/n";

        List<String> types = new ArrayList<>();
        types.add("rock");
        types.add("paper");
        types.add("scissors");

        System.out.print("""
                
                key 1 - play as "Rock",
                key 2 - play as "Paper",
                key 3 - play as "Scissors",
                key x - End game,
                key n - Restart game

                """);
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        int random = new Random().nextInt(1, 4);
        String randomType = "" + random;

        switch (type) {
            case "1" -> System.out.print(youPlayAs + "rock");
            case "2" -> System.out.print(youPlayAs + "paper");
            case "3" -> System.out.print(youPlayAs + "scissors");
            case "x" -> {
                System.out.print(confirmation);
                String yesNo = scan.nextLine();
                if (yesNo.equals("y")) {
                    System.exit(0);
                } else if (yesNo.equals("n")) {
                    System.out.println("Sorry to interrupt");
                } else {
                    throw new IllegalStateException("Unexpected value: " + type);
                }
            }
            case "n" -> {
                System.out.print(confirmation);
                String yesNo = scan.nextLine();
                if (yesNo.equals("y")) {
                    computerScore = 0;
                    playerScore = 0;
                    draw = 0;
                    main(new String[]{""});
                } else if (yesNo.equals("n")) {
                    main(new String[]{""});
                } else {
                    throw new IllegalStateException("Unexpected value: " + type);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        System.out.println();

        switch (randomType) {
            case "1" -> System.out.println(computerPlayAs + "rock");
            case "2" -> System.out.println(computerPlayAs + "paper");
            case "3" -> System.out.println(computerPlayAs + "scissors");
        }

        System.out.println();

        if (type.equals(randomType)) {
            System.out.println("It's a draw");
            draw++;
        } else if (type.equals("1")) {
            if (randomType.equals("2")) {
                System.out.println(computerWin);
                computerScore++;
            } else if (randomType.equals("3")) {
                System.out.println(playerWin);
                playerScore++;
            }
        } else if (type.equals("2")) {
            if (randomType.equals("1")) {
                System.out.println(playerWin);
                playerScore++;
            } else if (randomType.equals("3")) {
                System.out.println(computerWin);
                computerScore++;
            }
        } else if (type.equals("3")) {
            if (randomType.equals("1")) {
                System.out.println(computerWin);
                computerScore++;
            } else if (randomType.equals("2")) {
                System.out.println(playerWin);
                playerScore++;
            }
        }
        final String scoreBoard = " Computer | Player \n          |          \n     " + computerScore + "    |    " + playerScore + "    \n     Draw - " + draw;
        System.out.println(scoreBoard);
        main(new String[]{""});
    }
}
