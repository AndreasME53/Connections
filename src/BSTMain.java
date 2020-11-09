/**
 * BSTMain.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 26/04/2020<br>
 * This class was created to test that the binary search tree in BST works
 */
public class BSTMain {
    /**
     * This is the main method used to test the BST class
     */
    public static void main(String[] args) {

        Profile p = new Profile( "Michael","James", 16,01,1967
                ,"jamesmay@gmail.com",new String[]{"reading", "running" ,"Bowling", "ice skating"} ,
                new String[]{"activity1","activity2","activity3","activity4","activity5"});
        Profile p1 = new Profile("Ray", "Chris", 4,3,1970
                ,"chrisray@gmail.com", new String[]{"running","reading","glassblowing","interest2","activity1"}
                ,new String[]{"activity3","activity4","activity5","activity6","activity7"});
        Profile p2 = new Profile( "Young","Andrew", 22,2,1978
                ,"andrewyoung@gmail.com", new String[]{"climbing","reading","polo","fencing","poker"}
                ,new String[]{"activity3","activity4","activity5","activity6","activity7"});
        Profile p3 = new Profile( "Potter","Sofia", 8,6,1968
                ,"sofiapotter@gmail.com", new String[]{"volleyball","reading","gaming","swimming"}
                ,new String[]{"activity3","activity4","activity5","activity6","activity7"});
        Profile p4 = new Profile("Moller","Ted",  29,8,1970
                ,"tedmoller@gmail.com", new String[]{"running","reading","fishing"}
                ,new String[]{"activity3","activity4","activity5","activity6","activity7"});

        BST tree = new BST();
        tree.insertProfile(p);
        tree.insertProfile(p1);
        tree.insertProfile(p2);
        tree.insertProfile(p3);
        tree.insertProfile(p4);

    }
}
