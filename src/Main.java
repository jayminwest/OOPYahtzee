import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tempObj = new Scanner(System.in);
        String newGameUserSelection = "y";

        while (newGameUserSelection == "y") {
            Die[] currHand = HandOfDice.rollNewHand();

            HandOfDice.playHand(currHand);

            ScoreCard.processSortedHand(currHand);

            System.out.println("Play again? (enter 'y' for yes):");
                newGameUserSelection = tempObj.nextLine();
                    newGameUserSelection = newGameUserSelection.replaceAll("\\s", ""); //redundant but better safe than sorry
                System.out.println("User selection: " + newGameUserSelection);
        }
    }
}
