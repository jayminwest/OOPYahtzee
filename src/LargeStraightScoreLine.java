import java.util.ArrayList;

public class LargeStraightScoreLine extends ScoreLine {
    public static int targetStraightSize = 5; //this is by default yahtzee rules

    public LargeStraightScoreLine() {
        lineScore = 0;
        lineName = "Large Straight";
        taken = false;
        menuName = "lg";
    }

    public static String makeLargeStraightScoreLine(ArrayList<Die> currHand) {
        lineName = "Large Straight";
        lineScore = getLineScore(currHand);

        return makeString();
    }

    private static int getLineScore(ArrayList<Die> currHand) {
        if (findMaxString(currHand) >= targetStraightSize) {
            return 40; //Default Yahtzee rules dictates this should be 40
        }

        return 0;
    }

    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts - Taken: " + taken;

        return tempScoreLineString;
    }
}
