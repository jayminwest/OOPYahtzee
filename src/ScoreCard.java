/**
 * ScoreCard is where the scoring of the game takes place. This class uses HandOfDice and Die to process, calculate,
 * and Display the user's score. The scorecard is split into upper and lower sections and this is refleted in the methods
 * used.
 *
 * @author Jaymin West
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ScoreCard {
    /**
     * Takes sorted hand from result of HandOfDice and totals up scores
     *
     * @param sortedHand which is passed in from HandOfDice
     */
    public static void processSortedHand(Die[] sortedHand) {
        int[] upperScores = getUpperScores(sortedHand);
        int[] lowerScores = getLowerScores(sortedHand, upperScores);

        displayScoreCard(upperScores, lowerScores);
    }

    /**
     * Uses a loop to determine totals of each face for the upper section of the score card
     *
     * @param sortedHand is the current hand being passed in to be scored
     * @return int[] where the array is full of the upper Section's scores
     */
    public static int[] getUpperScores(Die[] sortedHand) {
        int oneTotal = 0, twoTotal = 0, threeTotal = 0, fourTotal = 0, fiveTotal = 0 ,sixTotal = 0;

        //Loop for upper section scores:
        for (int i = 0; i < sortedHand.length; i++) {
            if(sortedHand[i].getFace() == 1) {
                oneTotal += 1;
            } else if(sortedHand[i].getFace() == 2) {
                twoTotal += 2;
            } else if(sortedHand[i].getFace() == 3) {
                threeTotal += 3;
            } else if(sortedHand[i].getFace() == 4) {
                fourTotal += 4;
            } else if(sortedHand[i].getFace() == 5) {
                fiveTotal += 5;
            } else if(sortedHand[i].getFace() == 6) {
                sixTotal += 6;
            }
        }

        int[] upperScores = {oneTotal, twoTotal, threeTotal, fourTotal, fiveTotal, sixTotal};

        return upperScores;
    }

    /**
     * Processes lower section scores using the upper section scores and diceFrequency
     *
     * @param sortedHand is the same sorted Die array from HandOfDice's result
     * @param upperScores are the calculated scores from the getUpperScores method
     * @return int[] lowerScores where lowerScores is the total points for each catagory on the lower score section
     */
    public static int[] getLowerScores(Die[] sortedHand, int[] upperScores) {
        int threeOfKind = 0, fourOfKind = 0, fullHouse = 0, smStraight = 0, lgStraight = 0, yahtzee = 0, chance = IntStream.of(upperScores).sum();
        int [] diceFrequency = getDiceFrequency(sortedHand);

        //Loop for yahtzee, 3 of a kind, or 4 of a kind
        for (int i = 0; i < sortedHand.length; i++) {
            if (diceFrequency[i] == 3) {
                threeOfKind = IntStream.of(upperScores).sum();
            }
            if (diceFrequency[i] == 4) {
                fourOfKind = IntStream.of(upperScores).sum();
            }
            if (diceFrequency[i] == 5) {
                yahtzee = 100; //100 because a yahtzee is worth 100 points
            }

        }

        //If statements for large straight and small straight
        //This should be changed for HW2 so it is not limited to 1-6 combos
        if ((sortedHand[0].getFace() == sortedHand[1].getFace() - 1) &&
                (sortedHand[1].getFace() == sortedHand[2].getFace() - 1) &&
                (sortedHand[2].getFace() == sortedHand[3].getFace() - 1) &&
                (sortedHand[3].getFace() == sortedHand[4].getFace() - 1)) {
            lgStraight = 40;
        } else if ((upperScores[0] > 0) && (upperScores[1] > 0) && (upperScores[2] > 0) && (upperScores[3] > 0)) {
            smStraight = 30;
        }  else if ((upperScores[1] > 0) && (upperScores[2] > 0) && (upperScores[3] > 0) && (upperScores[4] > 0)) {
            smStraight = 30;
        } else if ((upperScores[2] > 0) && (upperScores[3] > 0) && (upperScores[4] > 0) && (upperScores[5] > 0)) {
            smStraight = 30;
        }

        //Need to add fullHouse
        if ((diceFrequency[0] == 3 || diceFrequency[1] == 3 || diceFrequency[2] == 3 ||  //Checking for three of a kind
                diceFrequency[3] == 3 || diceFrequency[4] == 3 || diceFrequency[5] == 3) && //Three of a kind
                (diceFrequency[0] == 2 || diceFrequency[1] == 2 || diceFrequency[2] == 2 || //Checking for two of a kind
                        diceFrequency[3] == 2 || diceFrequency[4] == 2 || diceFrequency[5] == 2)) { //Two of a kind
            fullHouse = 25;
        }

        int[] lowerScores = {threeOfKind, fourOfKind, fullHouse, smStraight, lgStraight, yahtzee, chance};

        return lowerScores;
    }

    /**
     * Counts the frequency of each face in a given hand. Currently can only process six faces, which is a flaw
     *
     * @param currHand is the HandOfDice being used to find frequency
     * @return int[] diceFrequency is the indexed array full of each face's frequency
     */
    public static int[] getDiceFrequency(Die[] currHand) {
        int [] diceFrequency = {0, 0, 0, 0, 0, 0}; //all faces' frequencies set to 0

        for (int i = 0; i < currHand.length; i++) { //must change this loop so it can be played with different settings
            if (currHand[i].getFace() == 1) diceFrequency[0]++;
            if (currHand[i].getFace() == 2) diceFrequency[1]++;
            if (currHand[i].getFace() == 3) diceFrequency[2]++;
            if (currHand[i].getFace() == 4) diceFrequency[3]++;
            if (currHand[i].getFace() == 5) diceFrequency[4]++;
            if (currHand[i].getFace() == 6) diceFrequency[5]++;
        }

        //System.out.println("Frequency: " + Arrays.toString(diceFrequency)); //Testing purposes

        return diceFrequency;
    }

    /**
     * Displays the score card using the upperScores and lowerScores array and numFaces from the "Die" class
     *
     * @param upperScores should be int[] from getUpperScores
     * @param lowerScores should be int[] from getLowerScores
     */
    public static void displayScoreCard(int[] upperScores, int[] lowerScores) {
        String[] lowerSectionNames = {"Three of a Kind", "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Yahtzee", "Chance"};
        //Loop to display upper section:
        for (int i = 0; i < Die.getNumFaces(); i++) {
            System.out.println("Scored " + upperScores[i] + " on the " + (i + 1) + " row.");
        }
        //Loop to display lower section:
        for (int i = 0; i < 7; i++) { //7 because that is the number of rows in lower section
            System.out.println("Scored " + lowerScores[i] + " on the " + lowerSectionNames[i] + " row.");
        }
    }
}
