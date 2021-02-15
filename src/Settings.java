import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Settings class:
 *  Elements
 *      numDice
 *      numRolls
 *      numFaces
 *      inFile
 * Methods
 *      readFile()
 *      changeFile() //based on user
 *      displaySettings()
 *      getUserSettings()
 *      Getters and setters
 *
 * @author Jaymin West
 */
public class Settings {
    private static int numSides = 0;
    private static int numDice = 0;
    private static int numRolls = 0;
    private static String fileName = "yahtzeeConfig.txt";

    public static void readFile() throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(fileName));

        numSides = Integer.parseInt(inFile.nextLine());

    }

    public static void displaySettings() {

    }
}
