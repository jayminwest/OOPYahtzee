/**
 *The purpose of this program is to play essentially the most bare bones version of Yahtzee. This version only has
 *one hand or three roles and one score card. The user is able to keep dice from previous roles or re-role the whole hand.
 *The player has no name or information and there is no saved data from one hand to the next. The score card simply shows the
 *scores from the single hand after the three roles have been made.
 *
 *CPSC224, Spring 2021, 02/07/2021
 *Homework #1
 *
 *@author Jaymin West
 */

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
