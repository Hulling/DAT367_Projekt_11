package com.example.dat367_projekt_11.models;

/**
 * The PersistenceManagerFactory is a class that follows factory pattern.
 *
 * @author  Kristin Hulling
 * @version 1.0
 * @since   2022-10-16
 */
public class PersistenceManagerFactory {
    public FirebasePersistenceManager getPersistenceManager(){
        return FirebasePersistenceManager.getInstance();
    }
}
