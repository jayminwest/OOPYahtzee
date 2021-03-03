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
     * @param currHand
     * @param workingFace
     * @return
     */
    public static String createUpperScoreLines(ArrayList<Die> currHand, int workingFace) {
        return IntegerScoreLine.makeIntegerScoreLine(currHand, workingFace);
    }

    public static ArrayList<String> createLowerScoreLines(ArrayList<Die> currHand, int numRows) {
        ArrayList<String> scoreLineString = new ArrayList<>(numRows);

        scoreLineString.add(0, ThreeOfKindScoreLine.makeThreeOfKindScoreLine(currHand));
        scoreLineString.add(1, FourOfKindScoreLine.makeFourOfKindScoreLine(currHand));
        scoreLineString.add(2, FullHouseScoreLine.makeFullHouseScoreLine(currHand));
        scoreLineString.add(3, SmallStraightScoreLine.makeSmallStraightScoreLine(currHand));
        scoreLineString.add(4, LargeStraightScoreLine.makeLargeStraightScoreLine(currHand));
        scoreLineString.add(5, YahtzeeScoreLine.makeYahtzeeScoreLine(currHand));
        scoreLineString.add(6, ChanceScoreLine.makeChanceScoreLine(currHand));

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

    public static int findMaxString(ArrayList<Die> currHand) {
        int maxLength = 1;
        int curLength = 1;

        for (int counter = 0; counter < numSides - 2; counter++) {
            if (currHand.get(counter).getFace() + 1 == currHand.get(counter + 1).getFace()) { //jump of 1
                curLength++;
            } else if (currHand.get(counter).getFace() + 1 < currHand.get(counter + 1).getFace()) {//jump of >= 2
                curLength = 1;
            }
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }
        return maxLength;
    }
}
