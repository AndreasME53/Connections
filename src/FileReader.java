import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/**
 * FileReader.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 26/04/2020<br>
 * This class is the file reader class used to read from a text file, create profile objects and to insert each profile
 * object's into a Binary Search Tree object in the right place
 */
public class FileReader {

    private static final String ERROR_MESSAGE_FOR_PROFILES = "There is a error with your profile.txt document, " +
            "please fix";
    /**
     * This Method is used to read and validate a text file String before passing it to another method to create
     * the binary search tree of profile objects
     * @param filename - the text files name
     * @return a binary tree object from the private readProfileSet method
     */
    public static BST readProfileSet (String filename){
        Scanner file = null;
        try {
            file = new Scanner(new File(filename));
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return FileReader.readProfileSet(file);
    }

    /**
     * This method is used to add profile objects to a binary search tree object
     * @param file - text file object with all the users details to be processed
     * @return a completed binary search tree object with profile objects
     */
    private static BST readProfileSet (Scanner file){
        BST tree = new BST();

        while(file.hasNextLine()){
            Scanner fileLine = new Scanner(file.nextLine()).useDelimiter(",");
            try{
                tree.insertProfile(createProfile(fileLine));
            }catch (Exception e){
                System.out.println(ERROR_MESSAGE_FOR_PROFILES);
                System.exit(1);
            }

            fileLine.close();
        }
        return tree;
    }

    /**
     * This method is designed to read from a single profile detail and create a profile object
     * @param fileLine - the file scanner object that contains one user's details from the text file
     * @return a profile object
     */
    private static Profile createProfile(Scanner fileLine) throws Exception {
        String sName = fileLine.next();
        String fName = fileLine.next();
        int day = fileLine.nextInt();
        int month = fileLine.nextInt();
        int year = fileLine.nextInt();
        String email = fileLine.next();
        String[] interests = fileLine.next().split(";");
        String[] activities = fileLine.next().split(";");
        return new Profile(sName, fName, day, month, year, email, interests, activities);
    }
}
