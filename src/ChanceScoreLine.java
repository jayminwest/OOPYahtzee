import java.util.ArrayList;

public class ChanceScoreLine extends ScoreLine {
    public ChanceScoreLine() {
        lineScore = 0;
        lineName = "Chance";
        taken = false;
        menuName = "c";
    }

    public static String makeChanceScoreLine(ArrayList<Die> currHand) {
        lineName = "Chance";
        lineScore = getLineScore(currHand);

        return makeString();
    }

    private static int getLineScore(ArrayList<Die> currHand) {
        int workingLineScore = 0;

        for (int i = 0; i < numDice; ++i) {
            workingLineScore += currHand.get(i).getFace();
        }

        return workingLineScore;
    }

    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts - Taken: " + taken;

        return tempScoreLineString;
    }
}
