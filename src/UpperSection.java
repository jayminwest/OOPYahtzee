import java.util.ArrayList;

public class UpperSection extends ScoreSection {
    //private static ArrayList<ScoreLine> scoreLines = makeScoreLines();
    public static String getUpperSection(ArrayList<Die> currHand) {
        ArrayList<String> scoreLines = makeScoreLines(currHand);

        return makeString(scoreLines);
    }

    public static ArrayList<String> makeScoreLines(ArrayList<Die> currHand) {
        ArrayList<String> newScoreLines = new ArrayList<String>(numSides);
        ScoreLine tempScoreLine = null;

        for (int i = 0; i <= numSides; ++i) {
            newScoreLines.add(i, "");
        }

        for (int i = 1; i <= numSides; i++) {
            newScoreLines.add(i, tempScoreLine.createScoreLines(currHand, i));
        }

        return newScoreLines;
    }

    private static String makeString(ArrayList<String> scoreLines) {
        String upperSectionString = "";

        upperSectionString += "-----Upper Section-----";
            for (int currScoreLine = 0; currScoreLine <= numSides; ++currScoreLine) {
                upperSectionString += scoreLines.get(currScoreLine) + "\n";
            }

        return upperSectionString;
    }
}
