package com.example.dat367_projekt_11.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Observer;


public class Chore implements Serializable, ModelFacade {
    private String name;
    private String description;
    private int points;
    private boolean isComplete;
  //  private Collection<IsCompleteListener> listeners = new ArrayList<>(); //listan med subscribers

    //Måste ha equals och hashcode.


    public Chore(String name, String description, int points){
        this.name = name;
        this.description = description;
        this.points = points;
        this.isComplete = false;
       // this.listeners = new ArrayList<>();
    }

    public Chore(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chore chore = (Chore) o;
        return points == chore.points && isComplete == chore.isComplete && name.equals(chore.name) && description.equals(chore.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, points, isComplete);
    }

    public void completeChore(){
        this.isComplete = true;
        //notifySubscribers();
    }
    public void unCompleteChore(){
        this.isComplete = false;
       // notifySubscribers();

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

    @Override
    public Chore getChore() {
        return this;
    }

  /*  public void subscribe(IsCompleteListener listener){
        if(!listeners.contains(listener)){//lägg till lyssnare om den ej finns redan
            listeners.add(listener);
        }
    }*/
/*
    public void unsubscribe(IsCompleteListener listener){
        listeners.remove(listener); //reset när timern går ut antar jag?
    }

    private void notifySubscribers() {  //notifiera lyssnare
        for (IsCompleteListener listener : listeners) {
                listener.update(this);
        }
    }*/









}
