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
        if (findFullHouse(currHand) == true) {
            return 25; //25 is the traditional score of a full house
        }

        return 0;
    }

    private static boolean findFullHouse (ArrayList<Die> currHand) {
        boolean foundFullHouse = false;
        boolean foundThreeOfKind = false;
        boolean foundTwoOfKind = false;
        int currentCount;

        for (int dieValue = 1; dieValue <= numSides; dieValue++) {
            currentCount = 0;

            for (int diePosition = 0; diePosition < 5; diePosition++) {
                if (currHand.get(diePosition).getFace() == dieValue)
                    currentCount++;
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

    private static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts - Taken: " + taken;

        return tempScoreLineString;
    }
}
