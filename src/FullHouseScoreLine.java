import java.util.ArrayList;

public class FullHouseScoreLine extends ScoreLine {
    public FullHouseScoreLine() {
        lineScore = 0;
        lineName = "Full House";
        taken = false;
        menuName = "fh";
    }

    public static String makeFullHouseScoreLine(ArrayList<Die> currHand) {
        lineName = "Full House";
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
