import java.util.ArrayList;

public class LargeStraightScoreLine extends ScoreLine {
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



        return 0;
    }

    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts - Taken: " + taken;

        return tempScoreLineString;
    }
}
