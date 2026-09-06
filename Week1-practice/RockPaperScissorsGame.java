import java.util.Scanner;

public class RockPaperScissorsGame {

    String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock")
                && computerMove.equalsIgnoreCase("Scissors"))
            || (playerMove.equalsIgnoreCase("Paper")
                && computerMove.equalsIgnoreCase("Rock"))
            || (playerMove.equalsIgnoreCase("Scissors")
                && computerMove.equalsIgnoreCase("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RockPaperScissorsGame game =
            new RockPaperScissorsGame();

        String[] moves = {
            "Rock", "Paper", "Scissors"
        };

        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < 5; i++) {

            System.out.print(
                "Enter your move (Rock/Paper/Scissors): "
            );

            playerMoves[i] = scanner.nextLine();

            int randomIndex =
                (int) (Math.random() * 3);

            computerMoves[i] = moves[randomIndex];

            results[i] =
                game.playRound(
                    playerMoves[i],
                    computerMoves[i]
                );

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println(
                "Round " + (i + 1) +
                " — Player: " + playerMoves[i] +
                ", Computer: " + computerMoves[i] +
                " | " + results[i]
            );
        }

        double winPercentage =
            ((double) wins / 5) * 100;

        System.out.println();
        System.out.println(
            "Round | Player Move | Computer Move | Result"
        );

        for (int i = 0; i < 5; i++) {

            System.out.println(
                (i + 1) + " | " +
                playerMoves[i] + " | " +
                computerMoves[i] + " | " +
                results[i]
            );
        }

        System.out.printf(
            "Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
            wins,
            losses,
            draws,
            winPercentage
        );

        scanner.close();
    }
}