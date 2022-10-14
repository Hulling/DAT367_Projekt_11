package com.example.dat367_projekt_11.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Profile implements IsCompleteListener, Serializable {
    private String name;
    private int currentPoints;
    private List<Chore> doneChores;//delmängd av alla householdChores bara chores med complete = true,
   // private ArrayList<DoneChoresListener> listeners;
    //private Chore chore;


    public Profile(String name) {
        this.currentPoints = 0;
        this.name = name;
        this.doneChores = new ArrayList<>();
    }
    public Profile(){}



   /* public Profile(int currentPoints, ArrayList<Chore> doneChores) {
        this.currentPoints = currentPoints;
        this.doneChores = doneChores;
    }*/



 //   public Profile() {}

    public String getName() {
        return name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }


    public void addToDoneChores(Chore chore){
        doneChores.add(chore);
        increaseCurrentPoints(chore);
    }
    public void removeFromDoneChores(Chore chore){
        doneChores.remove(chore);
        decreseCurrentPoints(chore); //ta bort poäng från profilen

    }

    private void increaseCurrentPoints(Chore chore){
        this.currentPoints += chore.getPoints();
    }

    private void decreseCurrentPoints(Chore chore){this.currentPoints -= chore.getPoints();}


    public List<Chore> getDoneChores(){
        return this.doneChores;
    }




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

    public void setName(String name){
        this.name = name;
    }
    /*
    DENNA KANSKE VI BEHÖVER TA BORT SENARE FÖR JAG ÄR LITE TIPSY NÄR JAG SKRIVER DETTA HEHE
     */
    void resetScore(){
        this.currentPoints=0;
    }

}