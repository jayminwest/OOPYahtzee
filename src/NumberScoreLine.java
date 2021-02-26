public class NumberScoreLine extends ScoreLine {

    public static void makeScoreLine(Die currDie) {
        lineScore = getLineScore(HandOfDice.currHand);
        lineName = "One's Line";
        taken = false;

    }

    public static int getLineScore(Die[] currHand) {
        int workingLineScore = 0;

        /*
        for (int currFace = 1; currFace <= numSides; ++currFace) {
            for (int posInHand = 0; posInHand <= currHand.length; posInHand++) {
                if (currHand[posInHand].getFace() == currFace){
                    workingLineScore += currFace;
                }
            }
        }
        */

        return workingLineScore;
    }
}
