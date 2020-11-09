/**
 * Profile.java
 * @version 1.0.0
 * @author Andreas Eleftheriades, 1906277
 * <b>Creation date</b> 28/03/2020<br>
 * <b>Last modified</b> 06/04/2020<br>
 * This class is for creating profiles
 */

import java.util.*;

public class Profile {
    private String sName;
    private String fName;
    private int day;
    private int month;
    private int year;
    private String email;
    private String[] interests;
    private String[] activities;
    private ArrayList<Profile> friends = new ArrayList<>();

    /**
     * Constructor of the profile used to fill all the user's main details.
     * @param sName - surname of the user
     * @param fName - first name of the user
     * @param day - day of birth of the user
     * @param month - month of birth of the user
     * @param year - year of birth of the user
     * @param email - the email of the user
     * @param interests - array of user interests
     * @param activities - array of user activities
     */
    public Profile(String sName,String fName,int day,int month,int year,String email,String[] interests,String[] activities){
        setsName(sName);
        setfName(fName);
        checkAndSetDate(day,month,year);
        setEmail(email);
        setInterests(interests);
        setActivities(activities);
    }

    /**
     * This method is used for validating that the user has entered in a valid date  before setting the profiles
     * date of birth if not an error will be thrown and caught
     * @param day - day of birth of the user
     * @param month - month of birth of the user
     * @param year - year of birth of the user
     */
    public void checkAndSetDate(int day,int month,int year){
        final String DATE_ERROR_MESSAGE = "Incorrect date, Please fix the data you have entered.";

        Calendar c = new GregorianCalendar(year,month,day);
        c.setLenient(false);
        c.set(year,month-1,day);
        try{
            c.getTime();
        }catch (IllegalArgumentException e){
            System.out.println(DATE_ERROR_MESSAGE);
            System.exit(1);
        }

        setDay(day);
        setMonth(month);
        setYear(year);
    }

    /**
     *  gets the surname
     * @return the surname
     */
    public String getsName() {
        return sName;
    }

    /**
     *  sets the surname
     * @param sName - surname
     */
    public void setsName(String sName) {
        this.sName = sName;
    }

    /**
     * gets first name
     * @return first name
     */
    public String getfName() {
        return fName;
    }

    /**
     * sets the first name
     * @param fName - first name
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     *  gets the day of birth
     * @return the day of birth
     */
    public int getDay() {
        return day;
    }

    /**
     * sets the day of birth
     * @param day - day of birth
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     *  gets the month of birth
     * @return the month of birth
     */
    public int getMonth() {
        return month;
    }

    /**
     *  sets the moth of birth
     * @param month - month of birth
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * gets the year of birth
     * @return - the year of birth
     */
    public int getYear() {
        return year;
    }

    /**
     * sets the user of birth
     * @param year - year of birth
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *  gets the email of user
     * @return user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     *  sets the user email
     * @param email - users email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets the users array of interests
     * @return array of user interests
     */
    public String[] getInterests() {
        return interests;
    }

    /**
     *  sets the array of user interests
     * @param interests - array of user interests passed in
     */
    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    /**
     *  gets list of user's activities
     * @return array of user activities
     */
    public String[] getActivities() {
        return activities;
    }

    /**
     *  passes in array of user activities
     * @param activities - array of user activities
     */
    public void setActivities(String[] activities) {
        this.activities = activities;
    }

    /**
     * re look at this one
     * " You should provide a getDateOfBirth method that re-turns a string with day, month and year all as integers"
     */
    public String getDateOfBirth(){
        return getDay()+" "+ getMonth() +" "+ getYear();
    }

    /**
     * adds a friend to the friend list
     * @param p is the friend to be added
     */
    public void addFriends(Profile p){
        this.friends.add(p);
    }

    /**
     * gets friend i from list
     * @param i friend number
     * @return friend profile
     */
    public Profile getFriend(int i){
        return (Profile) friends.get(i);
    }

    /**
     * method for returning the number of friends
     * @return the number of friends for this profile
     */
    public int numOfFriends(){
        return friends.size();
    }

    /**
     * method that converts the profile to a string and is used for testing
     * @return profile
     */
    public String toString(){
        return "First name is: " + getfName() +
                "\nSecond name is: " + getsName() +
                "\nDate of birth is: " + getDateOfBirth() +
                "\nEmail address is: " + getEmail() +
                "\ninterests are: " + Arrays.toString(getInterests()) +
                "\nactivity and groups" +  Arrays.toString(getActivities());
    }

    /**
     *  This method gets the profiles full name that is the last name and first name joined together
     * @return last name and first name appended
     */
    public String getFullName(){
        return getsName() + " "+ getfName();
    }

}
