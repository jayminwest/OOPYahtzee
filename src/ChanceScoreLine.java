import java.util.ArrayList;

/**
 * ChanceScoreLine calculates and creates the ScoreLine for it's respective ScoreLine
 */
public class ChanceScoreLine extends ScoreLine {
    //DVC
    public ChanceScoreLine() {
        lineScore = 0;
        lineName = "Chance";
        taken = false;
        menuName = "c";
    }

    /**
     * Driver method for this class. This is what is called from outside of this class.
     * Sets the line name to Chance for the makeString() method
     *
     * @param currHand
     * @return makeString()'s result
     */
    public static String makeChanceScoreLine(ArrayList<Die> currHand) {
        lineName = "Chance";
        lineScore = getLineScore(currHand);

        return makeString();
    }

    /**
     * getLineScore calculates the score total of the ChanceScoreLine
     *
     * @param currHand
     * @return workingLineScore, basically the sum of all the dice in the hand
     */
    private static int getLineScore(ArrayList<Die> currHand) {
        int workingLineScore = 0;

        for (int i = 0; i < numDice; ++i) {
            workingLineScore += currHand.get(i).getFace();
        }

        return workingLineScore;
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
