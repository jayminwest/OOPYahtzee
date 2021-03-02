import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

/**
 *
 */
public class ScoreLine {
    public static int lineScore; //The score on the current line
    public static String lineName; //Line name used for display purposes.
    public static boolean taken; //Tells program if line has been used already. Should be the first thing that is checked in each ScoreLine class
    public static String menuName; //(short, two chars) This is what the user enters to determine which line is being used (one's(1s), two's(2s), 3 of kind(3k), full house(fh), etc)
    public static int numDice = Settings.getNumDice();
    public static int numSides = Settings.getNumSides();

    public static String createScoreLines(ArrayList<Die> currHand, int workingFace) {
        String scoreLineString = IntegerScoreLine.makeIntegerScoreLine(currHand, workingFace);

        return scoreLineString;
    }

    public static String getUserMenuOption() {
        Scanner userSelectionScanner = new Scanner(System.in);
        String userSelection = "";

        System.out.println("Enter Menu Option: ");
            userSelection = userSelectionScanner.nextLine();
            userSelection = userSelection.replaceAll("\\s", "");

        return userSelection;
    }
}
