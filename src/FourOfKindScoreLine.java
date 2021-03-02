import java.util.ArrayList;

public class FourOfKindScoreLine extends ScoreLine {
    public FourOfKindScoreLine() {
        lineScore = 0;
        lineName = "NULL";
        taken = false;
        menuName = "fk";
    }

    public static String makeFourOfKindScoreLine(ArrayList<Die> currHand) {
        lineName = "Four of a Kind";
        lineScore = getLineScore(currHand);

        return makeString();
    }

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

    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += "4 of a kind - " + lineScore + " pts - Taken: " + taken;

        return tempScoreLineString;
    }
}
