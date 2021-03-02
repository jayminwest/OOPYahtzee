import java.util.Scanner;

import static java.lang.Integer.valueOf;

/**
 * Row is a class that makes up ScoreCard. It has a ScoreBox object, a String for the row name
 *
 * TODO: Make a method for using the user inputted menu option (1s, 2s, fh, etc)
 */
public class ScoreLine {
    public static int lineScore; //The score on the current line
    public static String lineName; //Line name used for display purposes.
    public static boolean taken; //Tells program if line has been used already. Should be the first thing that is checked in each ScoreLine class
    public static String menuName; //(short, two chars) This is what the user enters to determine which line is being used (one's(1s), two's(2s), 3 of kind(3k), full house(fh), etc)
    public static HandOfDice currentHand; //What is being compared/used to create each ScoreLine
    public static int numDice = Settings.getNumDice();
    public static int numSides = Settings.getNumSides();

    public static void createScoreLines(Die[] currHand) {
        int workingFace = 0;

        //THIS SHOULD BE IN PLAYER CLASS:
        String userSelection = getUserMenuOption(); //Make this so it can take any number+"s" for infinite numFaces i.e. 9s 12s

        /**
         *  Or, dont do any of that and have each scoreline have its own menu name
         *      then take the input, check if it matches any of them, if not ignore
         *          if it does set it to locked
         */
        workingFace = Character.getNumericValue(userSelection.charAt(0)); //This needs to work for any int value.

        String tempString = IntegerScoreLine.makeIntegerScoreLine(currHand, workingFace); //working face should change based on the userSelection
            System.out.println(tempString);

    }

    public static String getUserMenuOption() {
        Scanner userSelectionScanner = new Scanner(System.in);
        String userSelection = "";

        System.out.println("Enter Menu Option: ");
            userSelection = userSelectionScanner.nextLine();
            userSelection = userSelection.replaceAll("\\s", "");

        return userSelection;
    }
}
