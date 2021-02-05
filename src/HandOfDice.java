import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HandOfDice {
    //Main just creates a fresh hand and plays a turn
    public static void main(String[] args) {
        int numDice = 5; //This is set to five for a traditional game of Yahtzee
        int numTurns = 3; //Refers to the number of turns in a players hand, set to 3 for traditional gameplay

        Die[] currHand = rollNewHand(numDice);

        for (int i = 0; i < numTurns; i++) {
            displayHand(currHand);

            String userSelection = getUserSelection();

            processUserSelection(numDice, userSelection, currHand);
        }
        Arrays.sort(currHand, Comparator.comparing(Die::getFace)); //Sorts the hand in ascending order
            System.out.println("Your final sorted hand is: " + Arrays.toString(currHand));
                ScoreCard.processSortedHand(currHand);
    }

    //Returns a random hand of dice
    public static Die[] rollNewHand(int numDice) {
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

    //Runs through userSelection string
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


}
