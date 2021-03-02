public class IntegerScoreLine extends ScoreLine {

    public IntegerScoreLine() {
        lineScore = 0;
        lineName = "NULL";
        taken = false;
        menuName = "Integer";
    }

    public static String makeIntegerScoreLine(Die[] currHand, int workingFace) {
        lineName = String.valueOf(workingFace) + "'s ";
        lineScore = getLineScore(currHand, workingFace);
        menuName = workingFace + "s";
        taken = true;

        String returnString = makeString();
        return returnString; //This shouldn't return the string. There should be its own score line
    }

    public static int getLineScore(Die[] currHand, int workingFace) {
        int workingLineScore = 0;

        for (int posInHand = 0; posInHand < numDice; ++posInHand) {
            if (workingFace == currHand[posInHand].getFace()) {
                workingLineScore += currHand[posInHand].getFace();
            }
        }

        return workingLineScore;
    }

    public static String makeString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts" + " - " + "Taken: " + taken;

        return tempScoreLineString;
    }
}
