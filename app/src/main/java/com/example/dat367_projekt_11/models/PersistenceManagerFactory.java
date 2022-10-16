package com.example.dat367_projekt_11.models;


public class PersistenceManagerFactory {
    public FirebasePersistenceManager getPersistenceManager(){
        return FirebasePersistenceManager.getInstance();
    }
}
