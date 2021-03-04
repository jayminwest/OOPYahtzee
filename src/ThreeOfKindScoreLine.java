import java.util.ArrayList;

/**
 * This class is used for calculating hands that may have three of a kind
 */
public class ThreeOfKindScoreLine extends ScoreLine {
    //DVC
    public ThreeOfKindScoreLine() {
        lineScore = 0;
        lineName = "Three of a Kind";
        taken = false;
        menuName = "tk";
    }

    /**
     * Driver method for this class. This is what is called from outside of this class.
     * Sets the line name to Three of a Kind for the makeString() method
     *
     * @param currHand
     * @return makeString()'s result
     */
    public static String makeThreeOfKindScoreLine(ArrayList<Die> currHand) {
        lineName = "Three of a Kind";
        lineScore = getLineScore(currHand);

        return makeString();
    }

    /**
     * getLineScore calculates the score total of the ThreeOfKindScoreLine
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
            if (diceFrequency.get(i) >= 3) {
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
