package com.example.dat367_projekt_11.models;

/**
 * The PersistenceManagerFactory is a class that follows factory pattern.
 *
 * @author  Kristin Hulling
 */
public class PersistenceManagerFactory {
    /**
     * Get the persistenceManager.
     * @return PersistenceManager.
     */
    public FirebasePersistenceManager getPersistenceManager(){
        return FirebasePersistenceManager.getInstance();
    }
}
