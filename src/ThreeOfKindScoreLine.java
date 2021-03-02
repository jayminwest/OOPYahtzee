import java.util.ArrayList;

/**
 * This class is used for calculating hands that may be three of a kind
 */
public class ThreeOfKindScoreLine extends ScoreLine {
    public ThreeOfKindScoreLine() {
        lineScore = 0;
        lineName = "NULL";
        taken = false;
        menuName = "tk";
    }

    public static String makeThreeOfKindScoreLine(Die[] currHand) {
        lineName = "Three of a Kind";
        lineScore = getLineScore(currHand);

        String returnString = "three of kind return string";
        return returnString;
    }

    private static int getLineScore(Die[] currHand) {
        int workingLineScore = 0;
        ArrayList<Integer> diceFrequency = new ArrayList<>(numSides + 1);

        for (int i = 0; i < numDice; ++i) {
            workingLineScore += currHand[i].getFace();
        }

        for (int currDice = 0; currDice < currHand.length; ++currDice) {
            for (int currFace = 1; currFace <= numSides; ++currFace) {
                if (currHand[currDice].getFace() == currFace) {
                    diceFrequency.set(currFace, (diceFrequency.get(currFace) + 1));
                }
            }
        }

        for (int i = 1; i < numSides; ++i) {
            if (diceFrequency.get(i) == 3) {
                return workingLineScore;
            }
        }

        return 0;
    }
}
