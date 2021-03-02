public class IntegerScoreLine extends ScoreLine {

    public IntegerScoreLine() {
        lineScore = 0;
        lineName = "NULL";
        taken = false;
        //should also have menu name here
    }

    public static String makeIntegerScoreLine(Die[] currHand, int workingFace) {
        String returnString = "";

        lineName = String.valueOf(workingFace) + "'s " + "line";
        lineScore = getLineScore(currHand, workingFace);
        taken = true;

        returnString = lineName + "/" + lineScore + "/" + taken;

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

    public String toString() {
        String temp = "temp";
        return temp;
    }
}
