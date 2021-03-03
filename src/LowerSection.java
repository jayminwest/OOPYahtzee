import java.util.ArrayList;

public class LowerSection extends ScoreSection {
    public static int numRows = 7; //Seven is for 3, 4 of kind, full house, sm, lg straight, yahtzee, chance
    public static String getLowerSection (ArrayList<Die> currHand) {
        ArrayList<String> scoreLines = makeScoreLines(currHand);

        return makeString(scoreLines);
    }

    private static ArrayList<String> makeScoreLines(ArrayList<Die> currHand) {
        ArrayList<String> newScoreLines; //11 because the lower section has 11 lines
        ScoreLine tempScoreLine = null;

        newScoreLines = tempScoreLine.createLowerScoreLines(currHand, numRows);


        return newScoreLines;
    }

    private static String makeString(ArrayList<String> scoreLines) {
        String lowerSectionString = "";

        lowerSectionString += "-----Lower Section-----\n";
            for (int currScoreLine = 0; currScoreLine < numRows; ++currScoreLine) {
                lowerSectionString += scoreLines.get(currScoreLine) + "\n";
            }

        return lowerSectionString;
    }
}
