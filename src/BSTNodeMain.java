/**
 * BSTNodeMain.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 06/04/2020<br>
 * This class has a main method used to test that the BSTNode class works
 */
public class BSTNodeMain {
    public static void main(String[] args) {

        Profile p = new Profile( "michael","james", 16,01,1967
                ,"jamesmay@gmail.com",new String[]{"reading", "running" ,"Bowling", "ice skating"} ,
                new String[]{"activity1","activity2","activity3","activity4","activity5"});
        Profile p1 = new Profile("ray", "chris", 4,3,1970
                ,"chrisray@gmail.com", new String[]{"running","reading","glassblowing","interest2","activity1"}
                ,new String[]{"activity3","activity4","activity5","activity6","activity7"});
        Profile p2 = new Profile( "young","andrew", 22,2,1978
                ,"andrewyoung@gmail.com", new String[]{"climbing","reading","polo","fencing","poker"}
                ,new String[]{"activity3","activity4","activity5","activity6","activity7"});
        Profile p3 = new Profile( "potter","sofia", 8,6,1968
                ,"sofiapotter@gmail.com", new String[]{"volleyball","reading","gaming","swimming"}
                ,new String[]{"activity3","activity4","activity5","activity6","activity7"});
        Profile p4 = new Profile("moller","ted",  29,8,1970
                ,"tedmoller@gmail.com", new String[]{"running","reading","fishing"}
                ,new String[]{"activity3","activity4","activity5","activity6","activity7"});


        BSTNode n = new BSTNode(p);
        BSTNode n1 = new BSTNode(p1);
        BSTNode n2 = new BSTNode(p2);
        BSTNode n3 = new BSTNode(p3);
        BSTNode n4 = new BSTNode(p4);

        // connecting some nodes to test
        n.setL(n4);
        n.setR(n2);
        n1.setL(n3);
        n1.setR(n);
        n2.setR(n4);
        n2.setL(n1);

        //Printing out nodes and their connections
        System.out.println("1) Profile is: "+n.getProfile().getfName() + ". right node is: "
                + n.getR().getProfile().getfName() + ". left node is: " + n.getL().getProfile().getfName()+ "\n");
        System.out.println("2) Profile is: "+n1.getProfile().getfName() + ". right node is: "
                + n1.getR().getProfile().getfName() + ". left node is: " + n1.getL().getProfile().getfName()+ "\n");
        System.out.println("3) Profile is: "+n2.getProfile().getfName() + ". right node is: "
                + n2.getR().getProfile().getfName() + ". left node is: " + n2.getL().getProfile().getfName()+ "\n");
    }
}
