import java.util.ArrayList;

/**
 * This class is used for calculating hands that may be a yahtzee
 */
public class YahtzeeScoreLine extends ScoreLine {
    //DVC
    public YahtzeeScoreLine() {
        lineScore = 0;
        lineName = "Yahtzee";
        taken = false;
        menuName = "y";
    }

    /**
     * Driver method for this class. This is what is called from outside of this class.
     * Sets the line name to Yahtzee for the makeString() method
     *
     * @param currHand
     * @return makeString()'s result
     */
    public static String makeYahtzeeScoreLine(ArrayList<Die> currHand) {
        lineName = "Yahtzee";
        lineScore = getLineScore(currHand);

        return makeString();
    }

    /**
     * getLineScore calculates the score total of the YahtzeeScoreLine
     *
     * @param currHand
     * @return 100 or 0 based on if there was a yahtzee found or not
     */
    private static int getLineScore(ArrayList<Die> currHand) {
        int diceCount = 0;

        for (int i = 1; i < numDice; ++i) {
            if (currHand.get(i).getFace() == currHand.get(0).getFace()) {
                diceCount += 1;
            }
        }

        if (diceCount == numDice - 1) { //- 1 because the first dice is already counted
            return 100;
        }

        return 0;
    }

    /**
     * makeString() acts as the final product of this class. it takes all relevant info and puts it into a string
     *
     * @return the final scoreLine String
     */
    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts - Taken: " + taken;

        return tempScoreLineString;
    }
}
