/**
 * This class handles the score lines of all the integer lines in the upper score card
 */
public class IntegerScoreLine extends ScoreLine {

    public IntegerScoreLine() {
        lineScore = 0;
        lineName = "NULL";
        taken = false;
        menuName = "Integer";
    }

    public static String makeIntegerScoreLine(Die[] currHand, int workingFace) {
        lineName = String.valueOf(workingFace) + "'s ";
        lineScore = getLineScore(currHand, workingFace);
        menuName = workingFace + "s"; //This should be outside of this function and passed in, right?
        //taken = true; This shouldn't be set to true here, should be set to true when the player selects this lines for the points to go into

        String returnString = makeString();
        return returnString; //This shouldn't return the string. There should be its own score line
    }

    private static int getLineScore(Die[] currHand, int workingFace) {
        int workingLineScore = 0;

        for (int posInHand = 0; posInHand < numDice; ++posInHand) {
            if (workingFace == currHand[posInHand].getFace()) {
                workingLineScore += currHand[posInHand].getFace();
            }
        }

        return workingLineScore;
    }

    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts" + " - " + "Taken: " + taken;

        return tempScoreLineString;
    }
}
