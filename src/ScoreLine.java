import java.util.ArrayList;
import java.util.Scanner;
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

    /**
     *
     * @param currHand
     * @param workingFace
     * @return
     */
    public static String createUpperScoreLines(ArrayList<Die> currHand, int workingFace) { return IntegerScoreLine.makeIntegerScoreLine(currHand, workingFace); }

    public static String createLowerScoreLines(ArrayList<Die> currHand, String menuOption) {
        String scoreLineString = "";

        //could return all of lower score sheet as a string

        return scoreLineString;
    }

    /**
     * This is probably not needed in this class, but i am keeping it here because I know I'll need this exact method
     * in a different class in the future
     */
    public static String getUserMenuOption() {
        Scanner userSelectionScanner = new Scanner(System.in);
        String userSelection = "";

        System.out.println("Enter Menu Option: ");
            userSelection = userSelectionScanner.nextLine();
            userSelection = userSelection.replaceAll("\\s", "");

        return userSelection;
    }
}
