/**
 * ScoreCard is where the scoring of the game takes place. This class uses HandOfDice and Die to process, calculate,
 * and Display the user's score. The scorecard is split into upper and lower sections and this is refleted in the methods
 * used.
 *
 * TODO: fix index error in lowerScores, fix faceTotals in upperScores, change getDiceFrequency,
 *
 * @author Jaymin West
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ScoreCard {
    public static void main(String[] args) {

    }
    /**
     * Takes sorted hand from result of HandOfDice and totals up scores
     *
     * @param sortedHand which is passed in from HandOfDice
     */
    public static void processSortedHand(Die[] sortedHand) {
        ArrayList<Integer> upperScores = getUpperScores(sortedHand);

        //lowerScores is the problem with the program, not upperScores
        //ArrayList<Integer> lowerScores = getLowerScores(sortedHand, upperScores);

        //displayScoreCard(upperScores, lowerScores);
    }

    /**
     * Uses a loop to determine totals of each face for the upper section of the score card
     *
     * @param sortedHand is the current hand being passed in to be scored
     * @return int[] where the array is full of the upper Section's scores
     */
    public static ArrayList<Integer> getUpperScores(Die[] sortedHand) {
        ArrayList<Integer> faceTotals = new ArrayList<Integer>(Die.getNumFaces());

        for (int i = 0; i < Die.getNumFaces(); ++i) {
            faceTotals.add(i, 0);
        }

        System.out.println(Die.getNumFaces());

        for (int i = 0; i < Die.getNumFaces(); ++i) {
            for (int y = 0; y < Die.getNumFaces(); ++y) {
                if (sortedHand[y].getFace() == i) {
                    faceTotals.set(i, (faceTotals.get(i) + i));
                }
                System.out.println("Loop total of " + i + ": " + faceTotals.get(i));
            }
        }

        /*Loop for upper section scores:
        for (int i = 0; i < sortedHand.length; ++i) { //Where i is the current die face
            for (int y = 1; y < Die.getNumFaces(); ++y) { //Where y is the value the face is being compared to
                if (sortedHand[i].getFace() == y) {
                    faceTotals.set(i, (faceTotals.get(i) + y));
                }
            }
        }
           */
        for (int i = 0; i < sortedHand.length; ++i) {
            System.out.println("Final total of " + i + ": " + faceTotals.get(i));
        }

        return faceTotals;
    }

    /**
     * Processes lower section scores using the upper section scores and diceFrequency
     *
     * @param sortedHand is the same sorted Die array from HandOfDice's result
     * @param upperScores are the calculated scores from the getUpperScores method
     * @return int[] lowerScores where lowerScores is the total points for each catagory on the lower score section
     */
    public static ArrayList<Integer> getLowerScores (Die[] sortedHand, ArrayList<Integer> upperScores) {
        int threeOfKind = 0, fourOfKind = 0, fullHouse = 0, smStraight = 0, lgStraight = 0, yahtzee = 0, chance = 0;
        int sumOfHand = 0;
        int [] diceFrequency = getDiceFrequency(sortedHand);

        for(int i = 0; i < upperScores.size(); ++i) {
            sumOfHand = sumOfHand + sortedHand[i].getFace();
        } chance = sumOfHand;

        //Loop for yahtzee, 3 of a kind, or 4 of a kind
        for (int i = 0; i < sortedHand.length; i++) {
            if (diceFrequency[i] == 3) {
                threeOfKind = sumOfHand;

            }
            if (diceFrequency[i] == 4) {
                fourOfKind = sumOfHand;
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
        } else if ((upperScores.get(0) > 0) && (upperScores.get(1) > 0) && (upperScores.get(2) > 0) && (upperScores.get(3) > 0)) {
            smStraight = 30;
        }  else if ((upperScores.get(1) > 0) && (upperScores.get(2) > 0) && (upperScores.get(3) > 0) && (upperScores.get(4) > 0)) {
            smStraight = 30;
        } else if ((upperScores.get(2) > 0) && (upperScores.get(3) > 0) && (upperScores.get(4) > 0) && (upperScores.get(5) > 0)) {
            smStraight = 30;
        }

        if ((diceFrequency[0] == 3 || diceFrequency[1] == 3 || diceFrequency[2] == 3 ||  //Checking for three of a kind
                diceFrequency[3] == 3 || diceFrequency[4] == 3 || diceFrequency[5] == 3) && //Three of a kind
                (diceFrequency[0] == 2 || diceFrequency[1] == 2 || diceFrequency[2] == 2 || //Checking for two of a kind
                        diceFrequency[3] == 2 || diceFrequency[4] == 2 || diceFrequency[5] == 2)) { //Two of a kind
            fullHouse = 25;
        }

        ArrayList<Integer> lowerScores = new ArrayList<Integer>();
        lowerScores.add(threeOfKind);
        lowerScores.add(fourOfKind);
        lowerScores.add(fullHouse);
        lowerScores.add(smStraight);
        lowerScores.add(lgStraight);
        lowerScores.add(yahtzee);
        lowerScores.add(chance);

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
    public static void displayScoreCard(ArrayList<Integer> upperScores, ArrayList<Integer> lowerScores) {
        String[] lowerSectionNames = {"Three of a Kind", "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Yahtzee", "Chance"};
        //Loop to display upper section:
        for (int i = 0; i < Die.getNumFaces(); i++) {
            System.out.println("Scored " + upperScores.get(i) + " on the " + (i + 1) + " row.");
        }
        //Loop to display lower section:
        for (int i = 0; i < 7; i++) { //7 because that is the number of rows in lower section
            System.out.println("Scored " + lowerScores.get(i) + " on the " + lowerSectionNames[i] + " row.");
        }
    }
}
