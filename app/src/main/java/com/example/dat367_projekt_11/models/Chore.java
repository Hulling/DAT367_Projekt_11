package com.example.dat367_projekt_11.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 *This class represents the chore object.
 * @author Malin Kihlström
 * @author Hanna Harnesk
 * @author Kristin Hulling
 * @author Pauline Björk
 */

public class Chore implements Serializable {
    private String name;
    private String description;
    private int points;
   // private boolean isComplete;


    /**
     *
     * @param name the name of the chore from user input
     * @param description the description of the chore from user input
     * @param points the value of the chore when done
     */

    public Chore(String name, String description, int points){
        this.name = name;
        this.description = description;
        this.points = points;
      //  this.isComplete = false;
    }

    /**
     *Empty constructor for database reasons
     */

    public Chore(){

    }

    /**
     *Sets chore to complete and notifies the listeners
     */

    /*public void completeChore(){
        this.isComplete = true;
    }*/

    /**
     *TODO kommentera
     */
/*    public void unCompleteChore(){
        this.isComplete = false;

    }*/

    /**
     *Gets the name
     * @return the set name
     */

    public String getName() {
        return this.name;
    }

    /**
     *Gets the description
     * @return the set description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Gets the points
     * @return the set points
     */
    public int getPoints(){
        return this.points;
    }

    /**
     * Answers if it is completed
     * @return if the chore is complete
     */
 /*   public boolean isComplete(){
        return this.isComplete;
    }*/

    /**
     * Sets the name.
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description.
     * @param description the description to be set.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the points.
     * @param points the points to be set.
     */

    public void setPoints(int points) {
        this.points = points;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chore chore = (Chore) o;
        return points == chore.points && name.equals(chore.name) && description.equals(chore.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, points);
    }








}
