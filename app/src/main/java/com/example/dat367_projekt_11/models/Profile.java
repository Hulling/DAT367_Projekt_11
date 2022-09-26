package com.example.dat367_projekt_11.models;


import java.util.List;

public class Profile {
    private final String name;
    private int currentPoints;
    private List<Chore> doneChores;


    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }
    public void completeChore(Chore chore){
        chore.completeChore();
        doneChores.add(chore);
    }
}