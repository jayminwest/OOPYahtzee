import java.util.ArrayList;

/**
 *
 */
public class UpperSection extends ScoreSection {
    /**
     *
     */
    public static String getUpperSection(ArrayList<Die> currHand) {
        ArrayList<String> scoreLines = makeScoreLines(currHand);

        return makeString(scoreLines);
    }

    /**
     *
     * @param currHand
     * @return
     */
    public static ArrayList<String> makeScoreLines(ArrayList<Die> currHand) {
        ArrayList<String> newScoreLines = new ArrayList<String>(numSides);
        ScoreLine tempScoreLine = null;

        for (int i = 0; i <= numSides; ++i) {
            newScoreLines.add(i, "");
        }

        for (int i = 1; i <= numSides; i++) {
            newScoreLines.add(i, tempScoreLine.createUpperScoreLines(currHand, i));
        }

        return newScoreLines;
    }

    /**
     *
     * @param scoreLines
     * @return
     */
    private static String makeString(ArrayList<String> scoreLines) {
        String upperSectionString = "";

        upperSectionString += "-----Upper Section-----";
            for (int currScoreLine = 0; currScoreLine <= numSides; ++currScoreLine) {
                upperSectionString += scoreLines.get(currScoreLine) + "\n";
            }

        return upperSectionString;
    }
}
