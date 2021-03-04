/**
 * HandOfDice is the bulk of the gameplay. It creates an array of Die and uses that to roll, re-roll,
 * and keep dice that the player chooses before sorting it at the end of the hand.
 *
 * @author Jaymin West
 *
 */

import java.util.*;

public class HandOfDice {
    private static int numDice = Settings.getNumDice(); //Must change this so value comes from Settings class
    private static int numRolls = Settings.getNumRolls(); //Shouldn't be needed in this class
    public static ArrayList<Die> currHand = rollNewHand(); //This is a better option but requries lots of changing

    /**
     * Uses and returns currHand to play three turns/rolls, aka a "hand". Sorts the hand before returning it
     * @param currHand
     */

    public static ArrayList<Die> playHand (ArrayList<Die> currHand) {

        for (int i = 0; i < numRolls; i++) {
            displayHand(currHand);

            String userSelection = getUserSelection();

            processUserSelection(numDice, userSelection, currHand);
        }

        Collections.sort(currHand, Comparator.comparing(Die::getFace)); //Sorts the hand in ascending order
            System.out.println("Your final sorted hand is: " + currHand.toString());

        return currHand;
    }

    /**
     * Returns a random hand of dice
     * @return Die[] full of random faces from the Die DVC
     */
    public static ArrayList<Die> rollNewHand() {
        ArrayList<Die> newHand = new ArrayList<Die>();

        for (int i = 0; i < numDice; i++) {
            newHand.add(i, new Die());
        }

        return newHand;
    }

    /**
     * Displays the hand that is passed in
     * @param currHand where currHand is the current hand
     */
    public static void displayHand(ArrayList<Die> currHand) {
        System.out.println("Your hand is: " + Arrays.toString(new ArrayList[]{currHand}));
    }

    //Asks user to enter their choices and returns them as a string
    public static String getUserSelection() {
        Scanner tempObj = new Scanner(System.in);
        String tempString = "";

        System.out.println("Enter dice to keep (y or n): ");

        /*
         String userSelection = "";
                     userSelection = tempObj.nextLine();
                     userSelection = userSelection.replaceAll("\\s", ""); //removes spaces/white space
        */

        String userSelection = "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"; //*********REMOVE WHEN NOT TESTING************

        //if user doesn't enter in all characters it re-prompts them
        if (userSelection.length() < numDice) {
            System.out.println("Please enter " + numDice + " characters");
        } else{
            return userSelection;
        }
      return getUserSelection();
    }

    /**
     * Runs through userSelection string and re-rolls all dice that user did not enter 'y' to
     * @param numDice this is the generic number of dice for the whole class
     * @param userSelection where userSelection is the y's and n's the user entered
     * @param currHand this is the current hand passed in
     * @return Die[]
     */
    public static ArrayList<Die> processUserSelection(int numDice, String userSelection, ArrayList<Die> currHand) {
        char tempChar;

        //This loop checks the user input for the number of Dice and either keeps or rolls a new dice depending on user input
        for (int i = 0; i < numDice; i++) {
            tempChar = userSelection.charAt(i);
                if (tempChar != 'y') {
                    currHand.set(i, new Die());
                }
        }

        return currHand;
    }

    /**
     * Getters:
     * @return numDice and numRolls respectively
     */
    public static int getNumDice() {return numDice;}
    public static int getNumTurns() {return numRolls;}

    /**
     * Setters
     * @param numDiceParam and numTurnsParam respectively
     */
    public static void setNumDice(int numDiceParam) {numDice = numDiceParam;}
    public static void setNumTurns(int numTurnsParam) {numRolls = numTurnsParam;}

}
