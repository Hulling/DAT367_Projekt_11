package com.example.dat367_projekt_11.models;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

/**
 * The FacadeCurrentHousehold is a class with
 *The class methods is taken from https://developer.android.com/training/data-storage/app-specific
 *
 * @author  Kristin Hulling
 * @version 1.0
 * @since   2022-10-16
 */

public class FacadeCurrentHousehold {
    private final PersistenceManagerFactory persistenceManagerFactory;
    private final ConfigHandler configHandler;

    public FacadeCurrentHousehold(Context context) {
        this.persistenceManagerFactory = new PersistenceManagerFactory();
        this.configHandler = new ConfigHandler(context);
    }

    public MutableLiveData<Household> getHousehold(){
        MutableLiveData<Household> householdMutableLiveData;
        householdMutableLiveData = persistenceManagerFactory.getPersistenceManager().getHousehold(configHandler.getCurrentUser());
        return householdMutableLiveData;
    }
    public void addChore (Household household, Chore chore){
        persistenceManagerFactory.getPersistenceManager().addChoreToHousehold(household, chore);
    }
}
