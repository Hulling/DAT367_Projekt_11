package com.example.dat367_projekt_11.models;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

/**
 * The FacadeCurrentHousehold is a class that acs like a facade for configHandler and
 * persistenceMangerFactory.
 *
 * @author  Kristin Hulling
 */

public class FacadeCurrentHousehold {
    private final PersistenceManagerFactory persistenceManagerFactory;
    private final ConfigHandler configHandler;


    /**
     * Class constructor.
     * @param context Application context
     */
    public FacadeCurrentHousehold(Context context) {
        this.persistenceManagerFactory = new PersistenceManagerFactory();
        this.configHandler = new ConfigHandler(context);
    }
    /**
     * Method gets the current signed in household.
     * @return Th current signed in Household
     */
    public MutableLiveData<Household> getHousehold(){
        MutableLiveData<Household> householdMutableLiveData;
        householdMutableLiveData = persistenceManagerFactory.getPersistenceManager().getHousehold(configHandler.getCurrentUser());
        return householdMutableLiveData;
    }

    /**
     * Method adds a chore to the household in the database.
     * @param household Household that chore will be added to
     * @param chore Chore to be added to household.
     */
    public void addChore (Household household, Chore chore){
        persistenceManagerFactory.getPersistenceManager().addChoreToHousehold(household, chore);
    }

    /**
     * Method adds a done chore to the profile in the database.
     * @param household Household to find the profile in the database
     * @param chore Chore to be added to profile.
     */
    public void addChoreToDoneChores(Household household, Chore chore){
        GetCurrentProfile getCurrentProfile = GetCurrentProfile.getInstance();
        persistenceManagerFactory.getPersistenceManager().addDoneChoreToProfile(household, getCurrentProfile.getProfile(), chore);
    }

    /**
     * Method adds points to profile in the database.
     * @param household Household to find the profile in the database.
     * @param points Points to add to the profile.
     */
    public void addPointsToProfile(Household household, Integer points){
        GetCurrentProfile getCurrentProfile = GetCurrentProfile.getInstance();
        persistenceManagerFactory.getPersistenceManager().addPointsToProfile(household, getCurrentProfile.getProfile(), points);
    }


}
