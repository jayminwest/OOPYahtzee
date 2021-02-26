import java.util.ArrayList;

public class UpperSection extends ScoreCard {
    private static int numDice = Settings.getNumDice();
    private static int numSides = Settings.getNumSides();

    public void getUpperScores() {
        this.scoreRows = new ArrayList<Row>();
    }

}
