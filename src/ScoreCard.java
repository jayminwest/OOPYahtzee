import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ScoreCard {
    //Takes sorted hand from result of HandOfDice and totals up scores
    public static void processSortedHand(Die[] sortedHand) {
        int[] upperScores = getUpperScores(sortedHand);
        int[] lowerScores = getLowerScores(sortedHand, upperScores);

        displayScoreCard(upperScores, lowerScores);
    }

    //Uses a loop to determine totals of each face for the upper section of the score card
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

    //Processes lower section scores using the upper section scores
    public static int[] getLowerScores(Die[] sortedHand, int[] upperScores) {
        int threeOfKind = 0, fourOfKind = 0, fullHouse = 0, smStraight = 0, lgStraight = 0, yahtzee = 0, chance = IntStream.of(upperScores).sum();

        //Loop for yahtzee, 3 of a kind, or 4 of a kind (could not get || to work for some reason so split it into if statements)
        for (int i = 0; i < sortedHand.length; i++) {
            if (upperScores[i] == i * 4) {
                fourOfKind = IntStream.of(upperScores).sum();
            }
            if (upperScores[i] == i * 3) {
                threeOfKind = IntStream.of(upperScores).sum();
            }
        }

        //If statement for large straight and small straight
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

        int[] lowerScores = {threeOfKind, fourOfKind, fullHouse, smStraight, lgStraight, yahtzee, chance};

        return lowerScores;
    }

    //Displays the score card using the upperScores and lowerScores array and numFaces from the "Die" class
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
