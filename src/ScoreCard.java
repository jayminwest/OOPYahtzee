import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ScoreCard {
    public static void main(String args[]) {

    }

    //Takes sorted hand from result of HandOfDice and totals up scores
    public static void processSortedHand(Die[] sortedHand) {
        int[] upperScores = getUpperScores(sortedHand);
        int[] lowerScores = getLowerScores(sortedHand, upperScores);

        System.out.println("Upper Scores: " + Arrays.toString(upperScores));
        System.out.println("Lower Scores: " + Arrays.toString(lowerScores));
    }

    public static int[] getUpperScores(Die[] sortedHand) {
        int oneTotal = 0, twoTotal = 0, threeTotal = 0, fourTotal = 0, fiveTotal = 0 ,sixTotal = 0;

        //Loop for upper section:
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
        getLowerScores(sortedHand, upperScores);

        return upperScores;
    }

    //Processes lower section scores using the upper section scores
    public static int[] getLowerScores(Die[] sortedHand, int[] upperScores) {
        int threeOfKind = 0, fourOfKind = 0, fullHouse = 0, smStraight = 0, lgStraight = 0, yahtzee = 0, chance = 0;

        //Loop for 3 or 4 of a kind (could not get || to work for some reason so split it into two if statements)
        for (int i = 0; i < sortedHand.length; i++) {
            if (upperScores[i] == i * 4) {
                fourOfKind = IntStream.of(upperScores).sum();
            } else if (upperScores[i] == i * 3) {
              threeOfKind = IntStream.of(upperScores).sum();
             }
        }

        for (int i = 0; i < sortedHand.length; i++) {

        }

        int[] lowerScores = {threeOfKind, fourOfKind, fullHouse, smStraight, lgStraight, yahtzee, chance};

        return lowerScores;
    }
}
