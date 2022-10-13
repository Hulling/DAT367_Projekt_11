package com.example.dat367_projekt_11.models;


import java.util.ArrayList;


public class Profile implements IsCompleteListener {
    private String name;
    private int currentPoints = 0;
    private ArrayList<Chore> doneChores;//delmängd av alla householdChores bara chores med complete = true,
   // private ArrayList<DoneChoresListener> listeners;
    //private Chore chore;


    public Profile(String name) {
        this.name = name;
        this.doneChores = new ArrayList<Chore>();

    }

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
        chore.subscribe(this);
    }

    private void increaseCurrentPoints(Chore chore){
        this.currentPoints += chore.getPoints();
    }


    public ArrayList<Chore> getDoneChores(){
        return this.doneChores;
    }




    @Override
    public void update(Chore chore) {
        increaseCurrentPoints(chore);
        if (chore.isComplete()) { // om true
            addToDoneChores(chore);
        }else if (!chore.isComplete()){ //om false
            doneChores.remove(chore);
           // chore.unsubscribe(this);
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