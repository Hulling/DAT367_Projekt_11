package com.example.dat367_projekt_11.models;
/**
 * KLASSER OCH INTERFACES
 Describe what an object of this type represents. Use “this” to refer to an object of the current class
 Give all the information that a developer using your class would
 need to know
        Writing client code that calls your class
        Writing a subclass of your class
        Reusing your class in another program
 Tags that can be used in class/interface documentation comments
        @author name – author of the file
 For more than one author: use several @author tags, one per line, in chronological
 order, with class creator at top
        @version versionNumber

 */

/**
 * METODER:
 * First sentence should be a summary sentence, a complete description of the entity on its own
 *      Description should begin with verb, present tense, third person
 * @param name description – for each parameter.
 *                      Do not need to give types and arguments: Javadoc will get these from
 *                      the source code. List parameters in same order as in source code
 *
 * @return description – for return value
 *                      Omit if return type is void.
 *
 * @throws exceptionType description – for each exception that can be thrown
 *                      Hint: start description with “if”
 *
 *SHOULD document all public and protected members
 * MAY document private members
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observer;

/**
 *
 */

public class Chore implements Serializable {
    private String name;
    private String description;
    private int points;
    private boolean isComplete;
    private Collection<IsCompleteListener> listeners = new ArrayList<>(); //listan med subscribers

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
        this.isComplete = false;
        this.listeners = new ArrayList<>();
    }

    public Chore(){

    }

    public void completeChore(){
        this.isComplete = true;
        notifySubscribers();
    }
    public void unCompleteChore(){
        this.isComplete = false;
        notifySubscribers();

    }



    public String getName() {
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
    public int getPoints(){
        return this.points;
    }
    public boolean isComplete(){
        return this.isComplete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void subscribe(IsCompleteListener listener){
        if(!listeners.contains(listener)){//lägg till lyssnare om den ej finns redan
            listeners.add(listener);
        }
    }

    public void unsubscribe(IsCompleteListener listener){
        listeners.remove(listener); //reset när timern går ut antar jag?
    }

    private void notifySubscribers() {  //notifiera lyssnare
        for (IsCompleteListener listener : listeners) {
                listener.update(this);
        }
    }









}
