package com.example.dat367_projekt_11.models;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;

/**
 * This is a interface for communicating with a database. The purpose is to open the possibility
 * to change which database is used.
 *
 * @author  Kristin Hulling
 * @version 1.0
 * @since   2022-10-16
 */

public interface PersistenceManager {
    /**
     * This method is used for login a user.
     * @param email The email that will be signed in with.
     * @param password The password that will be signed in with.
     * @return The logged in user.
     */
    MutableLiveData<Household> login(String email, String password);

    /**
     * This method is used for register a new user.
     * @param email The email that will registered
     * @param password The password that will be registered
     * @param householdName the household name that will be registered.
     */
    void register(String email, String password, String householdName);

    /**
     * This method is used for creating household in the database
     * @param authenticatedHousehold The household that will be written in the database.
     */
    void createHouseholdInDatabaseIfNotExists(Household authenticatedHousehold);

    /**
     * This method is used to get a list of profile from the database.
     * @param household The household which we get the profile list from.
     * @return The list of profiles.
     */
    MutableLiveData<HashMap<String,Profile>> getProfileList(Household household);

    /**
     * This method is used for add a profile to the household in the database.
     * @param household The household that the profile will be added to.
     * @param profile The Profile that will be written in the database.
     */
    void addNewProfileToDatabase(Household household, Profile profile);

    /**
     * This method is used for get a household from database.
     * @param householdUid The user id from the household we want to get from the database.
     * @return Household from database.
     */
    MutableLiveData<Household> getHousehold(String householdUid);

    /**
     * This method is used for add a chore to the household in the database.
     * @param household The household that the chore will be added to.
     * @param chore The chore that will be written in the database.
     */
    void addChoreToHousehold(Household household, Chore chore);

}