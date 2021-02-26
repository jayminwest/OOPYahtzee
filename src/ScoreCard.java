/**
 * ScoreCard is where the scoring of the game takes place. This class uses HandOfDice and Die to process, calculate,
 * and Display the user's score. The scorecard is split into upper and lower sections and this is refleted in the methods
 * used.
 *
 * TODO: Objects to make: Rows, ScoreRows, change Die[] to object, UpperSection, LowerSection (both should inheret from ScoreCard)
 *
 * @author Jaymin West
 */

import java.util.ArrayList;

public class ScoreCard {
    public static ArrayList<ScoreLine> scoreRows;
    /**
     * Takes sorted hand from result of HandOfDice and totals up scores
     *
     * @param sortedHand which is passed in from HandOfDice
     */
    public static void processSortedHand(Die[] sortedHand) {
        ArrayList<Integer> upperScores = getUpperScores(sortedHand);

        ArrayList<Integer> lowerScores = getLowerScores(sortedHand, upperScores);

        displayScoreCard(upperScores, lowerScores);
    }

    /**
     * Uses a loop to determine totals of each face for the upper section of the score card
     *
     * @param sortedHand is the current hand being passed in to be scored
     * @return int[] where the array is full of the upper Section's scores
     */
    public static ArrayList<Integer> getUpperScores(Die[] sortedHand) {
        int numSides = Settings.getNumSides();
        int numDice = Settings.getNumDice();
        ArrayList<Integer> faceTotals = new ArrayList<Integer>(numSides);

        for (int i = 0; i < numSides + 1; ++i) {
            faceTotals.add(i, 0);
        }

            //start @ row one
            //Go up to max numSides, <=
            //Make a row object for each!
        for (int scoreRow = 1; scoreRow < numSides + 1; ++scoreRow) {
            int scoreRowTotal = 0;
            for (int y = 0; y < numDice; ++y) {
                if (sortedHand[y].getFace() == scoreRow) {
                    scoreRowTotal += scoreRow;
                }
            }
            faceTotals.set(scoreRow, scoreRowTotal);
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
        int numDice = Settings.getNumDice();
        int numSides = Settings.getNumSides();
        ArrayList<Integer> diceFrequency = getDiceFrequency(sortedHand);

        for(int i = 0; i < sortedHand.length; ++i) {
            sumOfHand = sumOfHand + sortedHand[i].getFace();
        } chance = sumOfHand;

        //Loop for yahtzee, 3 of a kind, or 4 of a kind
        for (int i = 1; i <= numSides; i++) {
                   // diceFrequency.get(i);
            if (diceFrequency.get(i) == 3) {
                threeOfKind = sumOfHand;
            }
            if (diceFrequency.get(i) == 4) {
                fourOfKind = sumOfHand;
            }
            if (diceFrequency.get(i) == numDice) {
                yahtzee = 100; //100 because a yahtzee is worth 100 points
            }

        }

        //If statements for large straight and small straight
        //This should be changed for HW2 so it is not limited to 1-6 combos
        if(numDice >= 5 && numSides >= 4) { //5 and 4 beacuse there needs to be at least 5 dice and 4 number of sides for a straight to exist
            if ((sortedHand[0].getFace() == sortedHand[1].getFace() - 1) &&
                    (sortedHand[1].getFace() == sortedHand[2].getFace() - 1) &&
                    (sortedHand[2].getFace() == sortedHand[3].getFace() - 1) &&
                    (sortedHand[3].getFace() == sortedHand[4].getFace() - 1)) {
                lgStraight = 40;
            } else if ((upperScores.get(0) > 0) && (upperScores.get(1) > 0) && (upperScores.get(2) > 0) && (upperScores.get(3) > 0)) {
                smStraight = 30;
            } else if ((upperScores.get(1) > 0) && (upperScores.get(2) > 0) && (upperScores.get(3) > 0) && (upperScores.get(4) > 0)) {
                smStraight = 30;
            } else if ((upperScores.get(2) > 0) && (upperScores.get(3) > 0) && (upperScores.get(4) > 0) && (upperScores.get(5) > 0)) {
                smStraight = 30;
            }
        }

        //Full House Loop:
        if(numDice >= 5 && numSides >= 4) { //This being set to four stops the program from breaking. Will be changed for HW3
            if ((diceFrequency.get(0) == 3 || diceFrequency.get(1) == 3 || diceFrequency.get(2) == 3 ||  //Checking for three of a kind
                    diceFrequency.get(3) == 3 || diceFrequency.get(4) == 3 || diceFrequency.get(5) == 3) && //Three of a kind
                    (diceFrequency.get(0) == 2 || diceFrequency.get(1) == 2 || diceFrequency.get(2) == 2 || //Checking for two of a kind
                            diceFrequency.get(3) == 2 || diceFrequency.get(4) == 2 || diceFrequency.get(5) == 2)) { //Two of a kind
                fullHouse = 25;
            }
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
     * Counts the frequency of each face in a given hand
     *
     * @param currHand is the HandOfDice being used to find frequency
     * @return int[] diceFrequency is the indexed array full of each face's frequency
     */
    public static ArrayList<Integer> getDiceFrequency(Die[] currHand) {
        int numSides = Settings.getNumSides();
        int numDice = Settings.getNumDice();
        ArrayList<Integer> diceFrequency = new ArrayList<>(numSides + 1);

        //Sets all the values of diceFrequency to 0
        for (int i = 0; i <= numSides; ++i) {
            diceFrequency.add(i, 0);
        }

        for (int currDice = 0; currDice < currHand.length; ++currDice) {
            for (int currFace = 1; currFace <= numSides; ++currFace) {
               if (currHand[currDice].getFace() == currFace) {
                   diceFrequency.set(currFace, (diceFrequency.get(currFace) + 1));
               }
            }
        }
        return diceFrequency;
    }

    /**
     * Displays the score card using the upperScores and lowerScores array and numSides from the "Die" class
     *
     * @param upperScores should be int[] from getUpperScores
     * @param lowerScores should be int[] from getLowerScores
     */
    public static void displayScoreCard(ArrayList<Integer> upperScores, ArrayList<Integer> lowerScores) {
        String[] lowerSectionNames = {"Three of a Kind", "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Yahtzee", "Chance"};
        //Loop to display upper section:
        for (int i = 1; i <= Die.getNumSides(); i++) {
            System.out.println("Scored " + upperScores.get(i) + " on the " + (i) + " row.");
        }
        //Loop to display lower section:
        for (int i = 0; i < 7; i++) { //7 because that is the number of rows in lower section
            System.out.println("Scored " + lowerScores.get(i) + " on the " + lowerSectionNames[i] + " row.");
        }
    }
}
