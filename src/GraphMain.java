/**
 * GraphMain.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 06/04/2020<br>
 * This class was created to tests if the graph class works works
 */
public class GraphMain {
    private static final String PROFILES_TXT = "profiles_01.txt";
    private static final String GRAPHS = "graph_01.txt";

    public static void main(String[] args) {
        BST profiles = FileReader.readProfileSet(PROFILES_TXT);
        Graph graph = new Graph(profiles,GRAPHS);

        Profile[] users = new Profile[3];
        users[0] = profiles.checkProfile("Kim Mark");
        users[1] = profiles.checkProfile("Brady Ellis");
        users[2] = profiles.checkProfile("Trevino Eliezer");

        BST[] testRecommendations = graph.friendRecommendations(users);

        for(int i = 0; i < users.length; i++){
            System.out.println("Friends Recommendations for " + users[i].getFullName());
            testRecommendations[i].printAlphabetical();
            System.out.println("=======================================================\n");
        }
    }
}
