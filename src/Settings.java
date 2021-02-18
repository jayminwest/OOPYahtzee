import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void main(String[] args) throws FileNotFoundException {
        readFile();
        displaySettings();
    }

    /**
     * readFile does as the title suggests. It reads from the specified settings file and applys the values to the numSides, numDice, and numRolls variables.
     *
     * @throws FileNotFoundException
     */
    public static void readFile() throws FileNotFoundException {
        String filePath = System.getProperty("user.dir");

        try {
            File currOpenFile = new File(filePath + "/src" + "/yahtzeeConfig.txt");
                Scanner inFile = new Scanner(currOpenFile);

            numSides = Integer.parseInt(inFile.nextLine());
            numDice = Integer.parseInt(inFile.nextLine());
            numRolls = Integer.parseInt(inFile.nextLine());
        } catch(Exception fileOpeningError) {
            System.out.println("Error opening inFile");
        }
    }

    public static void displaySettings() {
        Scanner tempObj = new Scanner(System.in);

        System.out.println("Current Settings: ");
        System.out.println("Number of sides: " + numSides);
        System.out.println("Number of dice: " + numDice);
        System.out.println("Number of rolls: " + numRolls);

        System.out.println("Do you want to change settings? (y for yes)");
            String userSelection = tempObj.nextLine();
                userSelection = userSelection.replaceAll("\\s", ""); //removes spaces/white space

        if(userSelection.charAt(0) == 'y') {
            changeSettings();
        }
    }

    public static void changeSettings() {
        Scanner tempObj = new Scanner(System.in);
        String userNumSides = "";
        String userNumDice = "";
        String userNumRolls = "";

        System.out.println("Enter in new number of sides per dice: ");
            userNumSides = removeWhiteSpace(tempObj.nextLine());
        System.out.println("Enter in new number of dice per roll: ");
            userNumDice = removeWhiteSpace(tempObj.nextLine());
        System.out.println("Enter in new number of rolls per hand: ");
            userNumRolls = removeWhiteSpace(tempObj.nextLine());

        try {
            String filePath = System.getProperty("user.dir");
            FileWriter settingsFileWriter = new FileWriter (filePath + "/src" + "/yahtzeeConfig.txt");

            settingsFileWriter.write(userNumSides);
            settingsFileWriter.write(userNumDice);
            settingsFileWriter.write(userNumRolls);

            displaySettings();
        } catch (IOException fileWriteError){
            System.out.println("Error in changing settings file");
        }
    }

    /**
     * simple utility method to help clean up changeSettings method
     * @param tempString
     * @return tempString
     */
    public static String removeWhiteSpace(String tempString) {
        tempString = tempString.replaceAll("//s", "");
        return tempString;
    }
}
