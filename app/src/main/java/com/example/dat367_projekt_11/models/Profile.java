package com.example.dat367_projekt_11.models;


import java.util.ArrayList;


public class Profile implements IsCompleteListener {
    private String name;
    private int currentPoints;
    private final ArrayList<Chore> doneChores;//delmängd av alla householdChores bara chores med complete = true,
    private ArrayList<DoneChoresListener> listeners;


    public Profile(String name) {
        this.name = name;
        this.doneChores = new ArrayList<Chore>();
    }

    /*public Profile(int currentPoints, ArrayList<Chore> doneChores) {
        this.currentPoints = currentPoints;
        this.doneChores = doneChores;
    }*/

    public Profile() {
        int currentPoints = 10/*this.currentPoints*/;
        this.doneChores = new ArrayList<Chore>();
    }


    public Profile() {}

    public String getName() {
        return name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }


    private void addToDoneChores(Chore chore){
        doneChores.add(chore);
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
        addToDoneChores(chore);
        notifyListeners();
    }

    private void notifyListeners() {
        for(DoneChoresListener listener : listeners){
            listener.update(doneChores);
        }
    }
    private void subscribe(DoneChoresListener listener) {
        listeners.add(listener);
    }

    public void setName(String name){
        this.name = name;
    }

}