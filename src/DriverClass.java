import java.util.Arrays;

/**
 * THIS CLASS IS ONLY FOR TESTING PURPOSES
 *
 * Goal as of 2/26: recreate HW1 with better/more objects
 */
public class DriverClass {
    public static void main(String args[]) {
       Die[] currHand = HandOfDice.rollNewHand();
       currHand = HandOfDice.playHand(currHand);


       ScoreLine.createScoreLines(currHand);

    }
}
