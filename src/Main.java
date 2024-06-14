import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            String playerAChoice = getPlayerChoice(scanner, "Player A");
            String playerBChoice = getPlayerChoice(scanner, "Player B");
            displayResult(playerAChoice, playerBChoice);

            System.out.print("Do you want to play again? [Y/N]: ");
            String playAgainChoice = scanner.next().toUpperCase();
            playAgain = playAgainChoice.equals("Y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getPlayerChoice(Scanner scanner, String player) {
        String choice = "";
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print(player + ", enter your move (R, P, S): ");
            choice = scanner.next().toUpperCase();
            if (choice.equals("R") || choice.equals("P") || choice.equals("S")) {
                validChoice = true;
            } else {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        }
        return choice;
    }

    private static void displayResult(String playerAChoice, String playerBChoice) {
        if (playerAChoice.equals(playerBChoice)) {
            System.out.println(getMoveName(playerAChoice) + " vs " + getMoveName(playerBChoice) + " - It's a Tie!");
        } else if (playerAChoice.equals("R") && playerBChoice.equals("S") ||
                playerAChoice.equals("P") && playerBChoice.equals("R") ||
                playerAChoice.equals("S") && playerBChoice.equals("P")) {
            System.out.println(getMoveName(playerAChoice) + " vs " + getMoveName(playerBChoice) + " - Player A wins!");
        } else {
            System.out.println(getMoveName(playerBChoice) + " vs " + getMoveName(playerAChoice) + " - Player B wins!");
        }
    }

    private static String getMoveName(String move) {
        switch (move) {
            case "R":
                return "Rock";
            case "P":
                return "Paper";
            case "S":
                return "Scissors";
            default:
                return "";
        }
    }
}