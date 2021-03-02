import java.util.ArrayList;
import java.util.Arrays;

/**
 * THIS CLASS IS ONLY FOR TESTING PURPOSES
 */
public class DriverClass {
    public static void main(String args[]) {
       ArrayList<Die> currHand = HandOfDice.rollNewHand();
       currHand = HandOfDice.playHand(currHand);

      String tempString = UpperSection.getUpperSection(currHand);
        System.out.println(tempString);

    }
}
