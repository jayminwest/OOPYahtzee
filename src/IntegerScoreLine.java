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

    public static String makeIntegerScoreLine(ArrayList<Die> currHand, int workingFace) {
        lineName = String.valueOf(workingFace) + "'s ";
        lineScore = getLineScore(currHand, workingFace);
        menuName = workingFace + "s"; //This should be outside of this function and passed in, right? I don't know

        return makeString();
    }

    private static int getLineScore(ArrayList<Die> currHand, int workingFace) {
        int workingLineScore = 0;

        for (int posInHand = 0; posInHand < numDice; ++posInHand) {
            if (workingFace == currHand.get(posInHand).getFace()) {
                workingLineScore += currHand.get(posInHand).getFace();
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
