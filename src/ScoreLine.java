/**
 * Row is a class that makes up ScoreCard. It has a ScoreBox object, a String for the row name
 */
public class ScoreLine {
    public static int lineScore; //The score on the current line
    public static String lineName; //Line name used for display purposes.
    public static boolean taken; //Tells program if line has been used already. Should be the first thing that is checked in each ScoreLine class
    public static String menuString; //(short, two chars) This is what the user enters to determine which line is being used (one's(1s), two's(2s), 3 of kind(3k), full house(fh), etc)
    public static HandOfDice currentHand; //What is being compared/used to create each ScoreLine
    private static int numDice = Settings.getNumDice();
    public static int numSides = Settings.getNumSides();

    public static void main(String args[]) {

    }

    public static void createScoreLines(Die[] currHand) {
        NumberScoreLine.makeScoreLine(currHand[0]);
    }
}
