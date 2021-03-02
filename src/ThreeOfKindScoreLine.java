import java.util.ArrayList;

/**
 * This class is used for calculating hands that may be three of a kind
 */
public class ThreeOfKindScoreLine extends ScoreLine {
    public ThreeOfKindScoreLine() {
        lineScore = 0;
        lineName = "Three of a Kind";
        taken = false;
        menuName = "tk";
    }

    /**
     *
     * @param currHand
     * @return
     */
    public static String makeThreeOfKindScoreLine(ArrayList<Die> currHand) {
        lineScore = getLineScore(currHand);

        return makeString();
    }

    /**
     *
     * @param currHand
     * @return
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
     *
     * @return String
     */
    private static String makeString() {
            String tempScoreLineString = "";

            tempScoreLineString += "3 of a kind - " + lineScore + " pts" + " - " + "Taken: " + taken;

            return tempScoreLineString;
    }
}
