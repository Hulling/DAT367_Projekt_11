package com.example.dat367_projekt_11.models;

import java.io.Serializable;

/**
 *This class represents the chore object.
 * @author Malin Kihlström
 * @author Hanna Harnesk
 */

public class Chore implements Serializable {
    private String name;
    private String description;
    private int points;

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
    }

    /**
     * Empty constructor. (for the ability to read from firebase Realtime database)
     */
    public Chore(){
        this("init", "init", 0);
    }


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


}
