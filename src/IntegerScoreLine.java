import java.util.ArrayList;

/**
 * This class handles the score lines of all the integer lines in the upper score card
 */
public class IntegerScoreLine extends ScoreLine {
    //DVC
    public IntegerScoreLine() {
        lineScore = 0;
        lineName = "NULL";
        taken = false;
        menuName = "Integer";
    }

    /**
     * Driver method for this class. This is what is called from outside of this class.
     * Sets the line name to the working face + 's for the makeString() method
     *
     * @param currHand
     * @return makeString()'s result
     */
    public static String makeIntegerScoreLine(ArrayList<Die> currHand, int workingFace) {
        lineName = String.valueOf(workingFace) + "'s ";
        lineScore = getLineScore(currHand, workingFace);
        menuName = workingFace + "s"; //This should be outside of this function and passed in, right? I don't know

        return makeString();
    }

    /**
     * getLineScore calculates the score total of the IntegerScoreLine
     *
     * @param currHand
     * @param workingFace which is the face that is passed in at the calling of this class
     * @return workingLineScore, basically the sum of all the same faces in the hand
     */
    private static int getLineScore(ArrayList<Die> currHand, int workingFace) {
        int workingLineScore = 0;

        for (int posInHand = 0; posInHand < numDice; ++posInHand) {
            if (workingFace == currHand.get(posInHand).getFace()) {
                workingLineScore += currHand.get(posInHand).getFace();
            }
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

        tempScoreLineString += lineName + " - " + lineScore + " pts" + " - " + "Taken: " + taken;

        return tempScoreLineString;
    }
}
