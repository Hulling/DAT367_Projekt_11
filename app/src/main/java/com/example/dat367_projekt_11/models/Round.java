package com.example.dat367_projekt_11.models;
/*
HAR TAGIT HJÄLP AV https://www.baeldung.com/java-timer-and-timertask
för att förstå timer, timerTask och treads
 */


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Malin Kihlström 2022-10
 */

public class Round{
    Household household; //TODO hämta rätt household från firebase
    List<RoundListener> roundListeners;

    public void onTimesUp() throws InterruptedException{
        TimerTask roundTask = new TimerTask() {
            public void run() {
                determineWinner();
                notifySubscribers();//TODO display on popup
                resetScores();
                resetChoreList();
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 10000L;
        long period = 1000L * 60L * 60L * 24L *7L;
        timer.scheduleAtFixedRate(roundTask,delay,period);

        }

    public void notifySubscribers(){
        for(RoundListener roundListener: roundListeners){
            roundListener.update();
        }
    }
    public void subscribe(RoundListener listener){
        roundListeners.add(listener);

    }
    void determineWinner(){
        /*
        Unsure if this should be here or if this work should be in
         household or scoreboard instead of delegating the work to them?
         */

    }

    void resetScores(){     //again, unsure whether this should be here or in household
        for(Profile profile : household.getProfileList()){
            profile.resetScore();
        }
    }
    void resetChoreList(){  //same with this method
        for(Chore chore : household.getHouseholdChores()){
            //TODO find a way to delete all chores from a household

        }
    }

    }

