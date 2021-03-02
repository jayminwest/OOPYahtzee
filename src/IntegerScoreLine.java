public class IntegerScoreLine extends ScoreLine {

    public void getIntegerScoreLine() { //Change this to be the driver file of this whole class

    }

    public IntegerScoreLine() {
        lineScore = 0;
        lineName = "NULL";
        taken = false;
        menuName = "Integer";
        //should also have menu name here
    }

    public String makeIntegerScoreLine(Die[] currHand, int workingFace) {
        lineName = String.valueOf(workingFace) + "'s ";
        lineScore = getLineScore(currHand, workingFace);
        menuName = workingFace + "s";
        taken = true;

        String returnString = toString();
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

    @Override
    public String toString() {
        String tempScoreLineString = "";

        tempScoreLineString += lineName + " - " + lineScore + " pts" + " - " + "Taken: " + taken;

        return tempScoreLineString;
    }
}
