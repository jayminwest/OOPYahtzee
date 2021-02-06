import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HandOfDice {
    private static int numDice = 5; //Set to five for traditional play
    private static int numTurns = 3; //Set to three for traditional play

    //Uses and returns currHand to play three turns/rolls, aka a "hand". Sorts the hand before returning it
    public static Die[] playHand (Die[] currHand) {
        for (int i = 0; i < numTurns; i++) {
            displayHand(currHand);

            String userSelection = getUserSelection();

            processUserSelection(numDice, userSelection, currHand);
        }

        Arrays.sort(currHand, Comparator.comparing(Die::getFace)); //Sorts the hand in ascending order
            System.out.println("Your final sorted hand is: " + Arrays.toString(currHand));

        return currHand;
    }

    //Returns a random hand of dice
    public static Die[] rollNewHand() {
        Die[] newHand = new Die[numDice];

        for (int i = 0; i < numDice; i++) {
            newHand[i] = new Die();
        }

        return newHand;
    }

    //Displays the hand that is passed in
    public static void displayHand(Die[] currHand) {
        System.out.println("Your hand is: " + Arrays.toString(currHand));
    }

    //Asks user to enter their choices and returns them as a string
    public static String getUserSelection() {
        Scanner tempObj = new Scanner(System.in);

        System.out.println("Enter dice to keep (y or n): ");

        String userSelection = "";
            userSelection = tempObj.nextLine();
            userSelection = userSelection.replaceAll("\\s", ""); //removes spaces/white space

        return userSelection;
    }

    //Runs through userSelection string and re-rolls all dice that user did not enter 'y' to
    public static Die[] processUserSelection(int numDice, String userSelection, Die[] currHand) {
        char tempChar;

        //This loop checks the user input for the number of Dice and either keeps or rolls a new dice depending on user input
        for (int i = 0; i < numDice; i++) {
            tempChar = userSelection.charAt(i);
                if (tempChar != 'y') {
                    currHand[i] = new Die();
                }
        }

        return currHand;
    }

    //Getters
    public static int getNumDice() {return numDice;}
    public static int getNumTurns() {return numTurns;}

    //Setters
    public static void setNumDice(int numDiceParam) {numDice = numDiceParam;}
    public static void setNumTurns(int numTurnsParam) {numTurns = numTurnsParam;}

}
