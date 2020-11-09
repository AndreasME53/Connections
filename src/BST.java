/**
 * BST.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 26/04/2020<br>
 * BST Class which creates a binary search tree instants formed of {@link BSTNode} objects
 */
import java.util.NoSuchElementException;
public class BST {
    /**
     * root node attributes
     */
    private BSTNode root;

    /**
     * Constructor of the binary tree object
     */
    public BST(){
        this.root = null;
    }

    /**
     * Binary tree insertion method
     * if this is the first node to be added the root attribute will point to it else it will be passed the
     * insert recursion method to alphabetically add the new profile to the binary tree
     * @param p - the user's profile to be added
     */
    public void insertProfile (Profile p){
        if(root == null){
            root = new BSTNode(p);
            //System.out.println("Setting root");
            //System.out.println("End");
        }else{
            //System.out.println("inserting from root");
        insert(root,p);}
    }

    /**
     * A recursive function which inserts a new profile node into the right place in the binary search tree
     * I have commented out a few print statements which i used to help debug my code. I left them in case they may help
     * @param node - a node which is used to keep track of the position in the binary tree
     * @param p - the user's profile to be added to the tree
     */
    private void insert(BSTNode node,Profile p){
        String nodeName = node.getProfile().getFullName();
        String profile = p.getFullName();
        int compared = nodeName.compareTo(profile);

        //System.out.println("comparing nodeName "+ nodeName+" and profile name "+ profile);

        if(compared > 0){
            // If the new profile is to be insert before the current node
            if(node.getR() == null) {
                node.setR(new BSTNode(p));
              //  System.out.println(profile+" is being added to the right");
            }else{
                //System.out.println("Going to the right node");
                insert(node.getR(),p);}
        }else{

            // else the new profile is to be insert after the current node
            if(node.getL() == null) {
            node.setL(new BSTNode(p));
            //System.out.println(profile+" is being added to the left");
            }else{
                //System.out.println("Going to the left node");
                insert(node.getL(),p);}
        }
    }

    private static final String ALPHABETICAL_ORDER_MESSAGE = "The following is in alphabetical order: (last name ," +
            " first name)";
    /**
     * This Method when called will print the binary tree's contents out in an alphabetical order
     */
    public void printAlphabetical() {
        System.out.println(ALPHABETICAL_ORDER_MESSAGE);
        print(root);
    }

    /**
     * This is the continuation of printAlphabetical method which recursively prints out the tree alphabetically
     * @param node - a node in the binary tree
     */
    private void print(BSTNode node){
        if (node == null) {return;}
        print(node.getR());
        System.out.println(node.getProfile().getFullName());
        print(node.getL());

    }
// below is for step 6.

    /**
     * Method which verifies that the name of a profile past in exists in the BST of profiles.
     * If it doesnt it will be caught and handled
     * @param fullName - is the profile name to verify
     * @return - the profile object
     */
    public Profile checkProfile(String fullName){
        try{
            return  verifyingProfile(root, fullName);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    /**
     * Method is a continuation of checkProfile(). Moreover if the profile name is correct it will return
     * the profile object but if it doesnt it will throw a error.
     * This is a recursive method that will search through the tree efficiently and not by looking at every tree node
     * @param node - a profile node in the tree to keep track of the position going through the tree and it will
     *        be compared to the past in profile name
     * @param fullName - is the profile name to verify
     */
    private Profile verifyingProfile(BSTNode node, String fullName) {
        final String ERROR_MESSAGE_FOR_PROFILES = "This profile does not exist: " + fullName;

        Profile profile = null;
        String nodeName = node.getProfile().getFullName();
        int compared = nodeName.compareTo(fullName);

        if (node.getProfile().getFullName().equals(fullName)) {
            profile = node.getProfile();
            return profile;
        }
        if (compared > 0) {
            if (node.getR() == null) {
                throw new NoSuchElementException(ERROR_MESSAGE_FOR_PROFILES);
            } else {
                return verifyingProfile(node.getR(), fullName);
            }
        } else {
            if (node.getL() == null) {
                throw new NoSuchElementException(ERROR_MESSAGE_FOR_PROFILES);
            } else {
                return verifyingProfile(node.getL(), fullName);
            }
        }
    }

}
