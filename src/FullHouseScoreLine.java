import java.util.ArrayList;

/**
 * FullHouseScoreLine computes if there is a FullHouse in the current hand of dice and creates a ScoreLine string based on this
 */
public class FullHouseScoreLine extends ScoreLine {
    //DVC
    public FullHouseScoreLine() {
        lineScore = 0;
        lineName = "Full House";
        taken = false;
        menuName = "fh";
    }

    /**
     * Driver method for this class. This is what is called from outside of this class.
     * Sets the line name to Full House for the makeString() method
     *
     * @param currHand
     * @return makeString()'s result
     */
    public static String makeFullHouseScoreLine(ArrayList<Die> currHand) {
        lineName = "Full House";
        lineScore = getLineScore(currHand);

        return makeString();
    }

    /**
     * This method calls the findFullHouse method and if it returns true then it returns the score of a full house
     *
     * @param currHand
     * @return lineScore
     */
    private static int getLineScore(ArrayList<Die> currHand) {
        if (findFullHouse(currHand) == true) {
            return 25; //25 is the traditional score of a full house
        }

        return 0;
    }

    /**
     * findFullHouse is a loop just checks if there are both 2 of one kind of die and 3 of another. This
     * algorithm was taken from the yahtzee demo provided in this repo
     *
     * @param currHand
     * @return bool for if a full house was found
     */
    private static boolean findFullHouse (ArrayList<Die> currHand) {
        boolean foundFullHouse = false;
        boolean foundThreeOfKind = false;
        boolean foundTwoOfKind = false;
        int currentCount;

        for (int dieValue = 1; dieValue <= numSides; dieValue++) {
            currentCount = 0;

            for (int diePosition = 0; diePosition < 5; diePosition++) {
                if (currHand.get(diePosition).getFace() == dieValue) {
                    currentCount++;
                }
            }

            if (currentCount == 2) {
                foundTwoOfKind = true;
            }

            if (currentCount == 3) {
                foundThreeOfKind = true;
            }

        }
        if (foundTwoOfKind && foundThreeOfKind) {
            foundFullHouse = true;
        }
        return foundFullHouse;
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
