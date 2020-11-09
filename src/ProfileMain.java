/**
 * ProfileMain.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 22/04/2020<br>
 * This class is used to test that the {@link Profile} class successfully operates
 */
public class ProfileMain {
    public static void main(String[] args) {
        String[] interests ={"action", "racing films"};
        String[] activityNGroups = {"running", "fishing","racing", "reading"};

        Profile p = new Profile( "may","james", 16,01,1967
                ,"jamesmay@gmail.com",interests ,activityNGroups);
        Profile p1 = new Profile( "ray","chris", 40,3,1970
                ,"chrisray@gmail.com",interests ,activityNGroups);

        p.addFriends(p1);
        //printing out the tostrings for both profiles to test



        System.out.println("The first profile: ");
        System.out.println(p.toString());
        System.out.println("\nThe second profile: ");
        System.out.println(p1.toString());

    }
}
