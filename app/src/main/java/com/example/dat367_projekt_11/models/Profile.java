package com.example.dat367_projekt_11.models;


import java.io.Serializable;
import java.util.HashMap;

/**
 * This class represents the profiles of Tidy App
 */
public class Profile implements IsCompleteListener, Serializable {
    private String name;
    private int currentPoints;
    private HashMap<String, Chore> doneChores;//delmängd av alla householdChores bara chores med complete = true,
   // private ArrayList<DoneChoresListener> listeners;
    //private Chore chore;

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

   /* public Profile(int currentPoints, ArrayList<Chore> doneChores) {
        this.currentPoints = currentPoints;
        this.doneChores = doneChores;
    }*/



 //   public Profile() {}

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
        increaseCurrentPoints(chore);
        doneChores.add(chore);
        increaseCurrentPoints(chore.getPoints());
        chore.subscribe(this); //börja subscriba på sysslan första gången den tillkommer till listan
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


    public HashMap<String, Chore> getDoneChores(){
    /**
     * Gets list of the completed chores
     * @return the completed chores
     */
    public List<Chore> getDoneChores(){
        return this.doneChores;
    }


    /**
     * Updates list of chores whenever a new chore has been completed (BORDE DELAS IN I TVÅ OLIKA? TODO)
     * @param chore the chore that has been completed
     */
    @Override
    public void update(Chore chore) {
        if (chore.isComplete()) { // om true -> syssla klar
            addToDoneChores(chore); // lägg till syssla i lista av gjrda sysslor, -> subscribe
        }else if (!chore.isComplete()){ //om false
            removeFromDoneChores(chore); //ta bort syssla från lista
        }
       // notifyListeners();
    }

/*    private void notifyListeners() {
        for(DoneChoresListener listener : listeners){
            listener.update(doneChores);
        }
    }*/
/*    public void subscribe(DoneChoresListener listener) {
        listeners.add(listener);
    }*/

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