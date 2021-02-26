/**
 * Row is a class that makes up ScoreCard. It has a ScoreBox object, a String for the row name
 */
public class Row {
    private static ScoreBox rowBoxScore;
    private static String rowName;



    public static ScoreBox getRowBoxScore() {
        return rowBoxScore;
    }

    public static void setRowBoxScore(ScoreBox rowBoxScore) {
        Row.rowBoxScore = rowBoxScore;
    }
}
