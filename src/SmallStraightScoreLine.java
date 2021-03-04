import java.util.ArrayList;

/**
 * SmallStraightScoreLine calculates and creates the ScoreLine for it's respective ScoreLine
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

    /**
     * Driver method for this class. This is what is called from outside of this class.
     * Sets the line name to Small Straight for the makeString() method
     *
     * @param currHand
     * @return makeString()'s result
     */
    public static String makeSmallStraightScoreLine(ArrayList<Die> currHand) {
        lineName = "Small Straight";
        lineScore = getLineScore(currHand);

        return makeString();
    }

    /**
     * getLineScore() uses the findMaxString() method in the ScoreLine class and checks it with targetStraightSize
     * it returns the score of the line based on if it was found or not
     *
     * @param currHand
     * @return int value of points scored
     */
    private static int getLineScore(ArrayList<Die> currHand) {
        if (findMaxStraight(currHand) >= targetStraightSize) {
            return 30;
        }

        return 0;
    }

    /**
     * makeString() acts as the final product of this class. it takes all relevant info and puts it into a string
     *
     * @return the final scoreLine String
     */
    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts - Taken: " + taken;

        return tempScoreLineString;
    }
}
