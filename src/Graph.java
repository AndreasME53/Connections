/**
 * Graph.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 27/04/2020<br>
 * Graph implementation. This will successfully add valid friend profiles together and find friend recommendations
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Graph {
    //Binary search tree of references to all Profile objects.
    private static BST binaryTree;

    /**
     * Constructor method for Graph.
     * Here, we use the method we created on BST.java which returned an ArrayList of all the profiles on the BST.
     * Then, readFile is called which opens the .txt file.
     * @param fileName the name of the file.
     * @param bTree A reference to a Binary Search Tree.
     */
    public Graph(BST bTree, String fileName){
        binaryTree = bTree;
        readFile(fileName);
    }

    /**
     * This method tries to check for friend recommendations
     * @param users - list of profiles
     * @return - list of binary search trees
     */
     public BST[] friendRecommendations(Profile[] users){
         BST usersFriendRecommendations[] = new BST[users.length];

         for(int i = 0; i < users.length; i++){
             usersFriendRecommendations[i] = new BST();
             // finally adding each user a BST of Recommended Friends
             usersFriendRecommendations[i] = findingRecommendedFriends(users[i]);
         }
         return usersFriendRecommendations;
     }

   /**
    * This is the quadratic method to finding recommended friends
    * @param user - the profile object to search for friend recommendations
    * @return the users BST of friend recommendations
    */
    private BST findingRecommendedFriends(Profile user){
        BST recommendedFriends = new BST();

        //looping through each users friends
        for(int i = 0 ; i < user.numOfFriends(); i++){
            Profile friend = user.getFriend(i);

            //looping through each friend Friends and seeing if to add that friend of user Friend to the BST
            for (int k = 0; k < friend.numOfFriends(); k++){

                boolean addToFriendRecommendation = true;
                Profile friendOfFriend = friend.getFriend(k);
                String friendName = friendOfFriend.getFullName();

                //looping through user's friends in case the friend of the friend is not already a friend
                for(int z = 0; z < user.numOfFriends(); z++){
                    String currentFriend = user.getFriend(z).getFullName();

                    if(currentFriend.equals(friendName)){
                        addToFriendRecommendation = false;
                    }
                }
                //check to see if to add the friend of friend to recommendation
                if(addToFriendRecommendation && !friendName.equals(user.getFullName())){
                    recommendedFriends.insertProfile(friendOfFriend);
                }
            }
        }
        return recommendedFriends;
    }

    /**
     * Method which adds both profiles as friends.
     * @param firstProfile The first profile.
     * @param secondProfile The second profile.
     */
    private static void addingFriends(Profile firstProfile, Profile secondProfile){
        firstProfile.addFriends(secondProfile);
        secondProfile.addFriends(firstProfile);
    }

    /**
     * Reads the two names from the each line, calls checkProfile() method to verify that both names exist in the BST.
     * if any name past in does not exit the error will be caught and handled. Finally if profiles exit
     * the addingfriends() method will be run
     * @param in - scanner with the friends to add
     */
    private static void readDataFile(Scanner in){

        Profile firstProfile = null;
        Profile secondProfile = null;
        while (in.hasNextLine()) {
            String curLine = in.nextLine();
            Scanner line = new Scanner(curLine).useDelimiter(",");
            String profile1 = line.next();
            String profile2 = line.next();
            try{
                firstProfile = binaryTree.checkProfile(profile1);
                secondProfile = binaryTree.checkProfile(profile2);
            }catch (NoSuchElementException e){
                System.out.println(e.getMessage());
                System.exit(1);
            }
            addingFriends(firstProfile, secondProfile);
            line.close();
        }
    }

    /**
     * Method to read the text file and then call the readDataFile function to read each line.
     * @param filename The name of the text file.
     */
    private static void readFile(String filename){
        Scanner in = null;
        try{
            in = new Scanner(new File(filename));
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        readDataFile(in);
    }
}