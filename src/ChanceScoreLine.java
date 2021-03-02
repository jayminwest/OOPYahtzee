import java.util.ArrayList;

public class ChanceScoreLine extends ScoreLine {
    public ChanceScoreLine() {
        lineScore = 0;
        lineName = "Chance";
        taken = false;
        menuName = "c";
    }

    public static String makeChanceScoreLine(ArrayList<Die> currHand) {
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
