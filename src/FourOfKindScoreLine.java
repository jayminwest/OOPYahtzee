import java.util.ArrayList;

/**
 * This class is used for calculating hands that may have four of a kind
 *
 */
public class FourOfKindScoreLine extends ScoreLine {
    //DVC
    public FourOfKindScoreLine() {
        lineScore = 0;
        lineName = "Four of a Kind";
        taken = false;
        menuName = "fk";
    }

    /**
     * Driver method for this class. This is what is called from outside of this class.
     * Sets the line name to Four of a Kind for the makeString() method
     *
     * @param currHand
     * @return makeString()'s result
     */
    public static String makeFourOfKindScoreLine(ArrayList<Die> currHand) {
        lineName = "Four of a Kind";
        lineScore = getLineScore(currHand);

        return makeString();
    }

    /**
     * getLineScore calculates the score total of the FourOfKindScoreLine
     *
     * @param currHand
     * @return workingLineScore, basically the sum of all the dice in the hand
     */
    private static int getLineScore(ArrayList<Die> currHand) {
        int workingLineScore = 0;
        ArrayList<Integer> diceFrequency = new ArrayList<>(numSides + 1);

        for (int i = 0; i < numDice; ++i) {
            workingLineScore += currHand.get(i).getFace();
        }

        for (int i = 0; i <= numSides; ++i) {
            diceFrequency.add(i, 0);
        }

        for (int currDice = 0; currDice < numDice; ++currDice) {
            for (int currFace = 1; currFace <= numSides; ++currFace) {
                if (currHand.get(currDice).getFace() == currFace) {
                    diceFrequency.set(currFace, (diceFrequency.get(currFace) + 1));
                }
            }
        }

        for (int i = 1; i < numSides; ++i) {
            if (diceFrequency.get(i) >= 4) {
                return workingLineScore;
            }
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
