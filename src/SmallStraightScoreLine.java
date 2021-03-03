import java.util.ArrayList;

/**
 *
 */
public class SmallStraightScoreLine extends ScoreLine {
    public static int targetStraightSize = 4;
    //DVC
    public SmallStraightScoreLine() {
        lineScore = 0;
        lineName = "Small Straight";
        taken = false;
        menuName = "sm";
    }

    public static String makeSmallStraightScoreLine(ArrayList<Die> currHand) {
        lineName = "Small Straight";
        lineScore = getLineScore(currHand);

        return makeString();
    }

    private static int getLineScore(ArrayList<Die> currHand) {
        if (findMaxString(currHand) >= targetStraightSize) {
            return 30;
        }

        return 0;
    }

    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts - Taken: " + taken;

        return tempScoreLineString;
    }
}
