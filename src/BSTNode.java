/**
 * BSTNode.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 26/04/2020<br>
 * This class creates Binary Search tree nodes this is {@link BST}
 */
public class BSTNode {
    private Profile data;
    private BSTNode l;
    private BSTNode r;

    /**
     * Constructor the creates the Binary Search Tree node object to be added to a BST object
     * @param data - the user's profile object
     */
    public BSTNode(Profile data){
        this.data = data;
        l = null;
        r = null;
    }

    /**
     * gets the profile object associated with this node object
     * @return - the profile object
     */
    public Profile getProfile(){
        return data;
    }

    /**
     * sets the left child of this node
     * @param l node to be set on the left
     */
    public void setL (BSTNode l){
        this.l = l;
    }

    /**
     * sets the right child of this node
     * @param r node to be set on the right
     */
    public void setR (BSTNode r){
        this.r = r;
    }

    /**
     * gets the left child of this node
     * @return the left node
     */
    public BSTNode getL(){
        return l;
    }

    /**
     * gets the right child of this node
     * @return the right node
     */
    public BSTNode getR(){
        return r;
    }
}
