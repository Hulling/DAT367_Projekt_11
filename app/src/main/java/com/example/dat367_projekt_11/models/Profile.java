package com.example.dat367_projekt_11.models;


import java.io.Serializable;
import java.util.HashMap;

/**
 * This class represents the profiles of Tidy App
 */
public class Profile implements Serializable {
    private String name;
    private int currentPoints;
    private HashMap<String, Chore> doneChores;//delmängd av alla householdChores bara chores med complete = true,


    /**
     *
     * @param name the name of the profile
     */

    public Profile(String name) {
        this.currentPoints = 0;
        this.name = name;
        this.doneChores = new HashMap<>();
    }

    /**
     * Empty constructor for database reasons
     */
    public Profile(){}



    /**
     * Gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the current points
     * @return the current points
     */
    public int getCurrentPoints() {
        return currentPoints;
    }

    /**
     * Adds chore from the list of done chores
     * @param chore the chore to be added from the list of done chores
     */
    public void addToDoneChores(Chore chore){
        doneChores.put(chore.getName(), chore);
        increaseCurrentPoints(chore.getPoints());

    }

    /**
     * Removes chore from the list of done chores
     * @param chore the chore to be removed from the list of done chores
     */
    public void removeFromDoneChores(Chore chore){
        doneChores.remove(chore);
        decreaseCurrentPoints(chore.getPoints()); //ta bort poäng från profilen

    }

    /**
     * Increases the current points
     * @param chorePoints the amount current point increases
     */
    private void increaseCurrentPoints(int chorePoints){
        this.currentPoints += chorePoints;
    }

    /**
     * Decreases the current points
     * @param chorePoints the amount current points decreases
     */
    private void decreaseCurrentPoints(int chorePoints){this.currentPoints -= chorePoints;}



    /**
     * Gets list of the completed chores
     * @return the completed chores
     */
    public HashMap<String, Chore> getDoneChores(){
        return doneChores;
    }

    /**
     * Updates list of chores whenever a new chore has been completed (BORDE DELAS IN I TVÅ OLIKA? TODO)
     * @param chore the chore that has been completed
     */


    /**
     * Sets the name
     * @param name the name to be set
     */
    public void setName(String name){
        this.name = name;
    }
    /*
    DENNA KANSKE VI BEHÖVER TA BORT SENARE FÖR JAG ÄR LITE TIPSY NÄR JAG SKRIVER DETTA HEHE
     */

    /**
     * Sets current score to 0
     */
    void resetScore(){
        this.currentPoints=0;
    }

}