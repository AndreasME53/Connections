/**
 * FileReaderMain.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 06/04/2020<br>
 * This method is used to test that the file reader class successfully runs
 */
public class FileReaderMain {
    private static final String PROFILES_TXT = "profiles_01.txt";
    public static void main(String[] args) {

        FileReader f = new FileReader();
        BST tree =  f.readProfileSet(PROFILES_TXT);
        tree.printAlphabetical();

    }
}
