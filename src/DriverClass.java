import java.util.ArrayList;
import java.util.Arrays;

/**
 * THIS CLASS IS ONLY FOR TESTING PURPOSES
 */
public class DriverClass {
    public static void main(String args[]) {
       ArrayList<Die> currHand = HandOfDice.rollNewHand();
        //Testing purposes:
        currHand.get(0).setFace(1);
        currHand.get(1).setFace(2);
        currHand.get(2).setFace(3);
        currHand.get(3).setFace(4);
        currHand.get(4).setFace(5);

       currHand = HandOfDice.playHand(currHand);
       String tempString = "";

        tempString = UpperSection.getUpperSection(currHand);
            System.out.println(tempString);

        tempString = LowerSection.getLowerSection(currHand);
            System.out.println(tempString);

    }
}
