import java.util.ArrayList;
import java.util.Arrays;

/**
 * THIS CLASS IS ONLY FOR TESTING PURPOSES
 */
public class DriverClass {
    public static void main(String args[]) {
       ArrayList<Die> currHand = HandOfDice.rollNewHand();
       currHand = HandOfDice.playHand(currHand);
       String tempString = "";

        currHand.get(0).setFace(1);
        currHand.get(1).setFace(1);
        currHand.get(2).setFace(1);
        currHand.get(3).setFace(2);
        currHand.get(4).setFace(2);


        tempString = UpperSection.getUpperSection(currHand);
            System.out.println(tempString);

        tempString = ThreeOfKindScoreLine.makeThreeOfKindScoreLine(currHand);
            System.out.println(tempString);

        tempString = FourOfKindScoreLine.makeFourOfKindScoreLine(currHand);
            System.out.println(tempString);

        tempString = YahtzeeScoreLine.makeYahtzeeScoreLine(currHand);
            System.out.println(tempString);

    }
}
