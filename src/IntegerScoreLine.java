public class IntegerScoreLine extends ScoreLine {

    public IntegerScoreLine() {
        lineScore = 0;
        lineName = "NULL";
        taken = false;
    }

    public static String makeScoreLine(Die[] currHand, int workingFace) {
        String returnString = "";

        lineName = String.valueOf(workingFace) + "'s " + "line";
        lineScore = getLineScore(currHand, workingFace);
        taken = true;

        returnString = lineName + "/" + lineScore + "/" + taken;

        return returnString;
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
}
