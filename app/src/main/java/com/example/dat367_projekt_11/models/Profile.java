package com.example.dat367_projekt_11.models;


import java.util.ArrayList;
import java.util.List;

public class Profile implements ChoreStatusListener {
    private String name;
    private int currentPoints;
    private final ArrayList<Chore> doneChores;//delmängd av alla householdChores bara chores med complete = true,

    public Profile(String name) {
        this.name = name;
        this.doneChores = new ArrayList<Chore>();
    }

    public String getName() {
        return name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }


    private void addChoretoCompletedChore(Chore chore){
        doneChores.add(chore);
    }
    private void addPointToCurrentPoints(Chore chore){
        this.currentPoints += chore.getPoints();
    }


    public List<Chore> getDoneChores(){
        return this.doneChores;
    }


    @Override
    public void update(Chore chore) {
        addPointToCurrentPoints(chore);
        addChoretoCompletedChore(chore);
    }

    public void setName(String name) {
        this.name = name;
    }
}