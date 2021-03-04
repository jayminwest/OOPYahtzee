import java.util.ArrayList;
import java.util.Scanner;

/**
 * ScoreLine is in a way the driver file for creating the ScoreLines that make up the ScoreSections
 */
public class ScoreLine {
    public static int lineScore; //The score on the current line
    public static String lineName; //Line name used for display purposes.
    public static boolean taken; //Tells program if line has been used already. Should be the first thing that is checked in each ScoreLine class
    public static String menuName; //(short, two chars) This is what the user enters to determine which line is being used (one's(1s), two's(2s), 3 of kind(3k), full house(fh), etc)
    public static int numDice = Settings.getNumDice();
    public static int numSides = Settings.getNumSides();

    /**
     * createUpperScoreLines is what UpperSection calls to create itself.
     *
     * @param currHand current hand
     * @param workingFace this is the current dice face that is passed in
     * @return String of the entire UpperScoreSection
     */
    public static String createUpperScoreLines(ArrayList<Die> currHand, int workingFace) {
        return IntegerScoreLine.makeIntegerScoreLine(currHand, workingFace);
    }

    /**
     * createLowerScoreLines is what LowerSection calls to create itself.
     *
     * @param currHand current hand
     * @param numRows this determines the size of the ArrayList based on how may rows are in the lowerSection
     * @return String of the entire UpperScoreSection
     */
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
     * findMaxStraight seaches the current hand for any straights and returns the size of the largest one.
     * This method is used by the Large and SmallStraightScoreLine classes
     *
     * @param currHand
     * @return maxLength of any straights found
     */
    public static int findMaxStraight(ArrayList<Die> currHand) {
        int maxLength = 1;
        int curLength = 1;

        for (int counter = 0; counter < numSides - 2; counter++) {
            /**KNOWN BUG: This line causes an index error when numSides > numDice*/
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
