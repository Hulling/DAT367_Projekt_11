package com.example.dat367_projekt_11.models;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

public class FacadeGetHousehold {
    private final PersistenceManagerFactory persistenceManagerFactory;
    private final ConfigHandler configHandler;

    public FacadeGetHousehold(Context context) {
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
    public void addChoreToDoneChores(Household household, Chore chore){
        GetCurrentProfile getCurrentProfile = GetCurrentProfile.getInstance();
        persistenceManagerFactory.getPersistenceManager().addDoneChoreToProfile(household, getCurrentProfile.getProfile(), chore);
    }

}
