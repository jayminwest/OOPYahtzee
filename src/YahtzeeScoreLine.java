import java.util.ArrayList;

/**
 *
 */
public class YahtzeeScoreLine extends ScoreLine {
    //DVC
    public YahtzeeScoreLine() {
        lineScore = 0;
        lineName = "NULL";
        taken = false;
        menuName = "y";
    }
    /**
     *
     */
    public static String makeYahtzeeScoreLine(ArrayList<Die> currHand) {
        lineName = "Yahtzee";
        lineScore = getLineScore(currHand);

        String returnString = makeString();
        return returnString;
    }
    /**
     *
     */
    private static int getLineScore(ArrayList<Die> currHand) {
        int diceCount = 0;

        for (int i = 1; i < numDice; ++i) {
            if (currHand.get(i).getFace() == currHand.get(0).getFace()) {
                diceCount += 1;
            }
        }

        if (diceCount == numDice - 1) { //- 1 because the first dice is already counted
            return 100;
        }

        return 0;
    }

    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += "Yahtzee - " + lineScore + " pts - Taken: " + taken;

        return tempScoreLineString;
    }
}
