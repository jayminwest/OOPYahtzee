import java.util.ArrayList;

/**
 * LargeStraightScoreLine calculates and creates the ScoreLine for it's respective ScoreLine
 */
public class LargeStraightScoreLine extends ScoreLine {
    public static int targetStraightSize = 5; //this is by default yahtzee rules

    //DVC
    public LargeStraightScoreLine() {
        lineScore = 0;
        lineName = "Large Straight";
        taken = false;
        menuName = "lg";
    }

    /**
     * Driver method for this class. This is what is called from outside of this class.
     * Sets the line name to Large Straight for the makeString() method
     *
     * @param currHand
     * @return makeString()'s result
     */
    public static String makeLargeStraightScoreLine(ArrayList<Die> currHand) {
        lineName = "Large Straight";
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
            return 40; //Default Yahtzee rules dictates this should be 40
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
