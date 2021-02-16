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

    public static void main(String[] args) throws FileNotFoundException {
        readFile();
        displaySettings();
    }

    public static void readFile() throws FileNotFoundException {
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        String filePath = System.getProperty("user.dir");

        try {
            File currOpenFile = new File(filePath);
            Scanner inFile = new Scanner(currOpenFile);
            while (inFile.hasNextLine()) {
                System.out.println(inFile.nextLine());
            }
        } catch (Exception fileError) {
            System.out.println("Error in opening file");
        }

        //numSides = Integer.parseInt(inFile.nextLine());
       // numDice = Integer.parseInt(inFile.nextLine());
       // numRolls = Integer.parseInt(inFile.nextLine());

    }

    public static void displaySettings() {
        Scanner tempObj = new Scanner(System.in);

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
        
    }
}
