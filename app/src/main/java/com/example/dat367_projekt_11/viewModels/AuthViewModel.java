package com.example.dat367_projekt_11.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.example.dat367_projekt_11.models.Profile;

import java.util.HashMap;

/**
 * The class is a viewModel. It handles communication between fragments and the PersistenceManger
 * without them talking direct to each other, via Mutable livedata.
 *
 * The Livedatabinding is inspired from:
 * https://www.digitalocean.com/community/tutorials/android-mvvm-livedata-data-binding
 *
 * @author  Kristin Hulling
 * @version 1.0
 * @since   2022-10-16
 */

public class AuthViewModel extends AndroidViewModel {
    private final PersistenceManagerFactory persistenceManagerFactory;
    private MutableLiveData<Household> authenticatedHouseholdLiveData;
    private MutableLiveData<Household> registerHouseholdLiveData;

    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<String> householdName = new MutableLiveData<>();

    private MutableLiveData<String> profileName = new MutableLiveData<>();

    public MutableLiveData<String> getProfileName(){
        if(profileName == null){
            profileName = new MutableLiveData<>();
        }
        return profileName;
    }

    public MutableLiveData<Household> getAuthenticatedHousehold() {
        if (authenticatedHouseholdLiveData == null) {
            authenticatedHouseholdLiveData = new MutableLiveData<>();
        }
        return authenticatedHouseholdLiveData;
    }

    public MutableLiveData<Household> getRegisterHousehold() {
        if (registerHouseholdLiveData == null) {
            registerHouseholdLiveData = new MutableLiveData<>();
        }
        return registerHouseholdLiveData;
    }


    public MutableLiveData<String> getEmail() {
        if (email == null) {
            email = new MutableLiveData<>();
        }
        return email;
    }
    public MutableLiveData<String> getPassword() {
        if (password == null) {
            password = new MutableLiveData<>();
        }
        return password;
    }
    public MutableLiveData<String> getHouseholdName() {
        if (householdName == null) {
            householdName = new MutableLiveData<>();
        }
        return householdName;
    }

    public AuthViewModel(@NonNull Application application) {
        super(application);
        persistenceManagerFactory = new PersistenceManagerFactory();

    }

    public void login(String email, String password) {
        authenticatedHouseholdLiveData = persistenceManagerFactory.getPersistenceManager().login(email, password);
    }

    public void register(String email, String password, String householdName){
        registerHouseholdLiveData = persistenceManagerFactory.getPersistenceManager().register(email, password, householdName);
    }

    public void createHousehold(Household authenticatedHousehold) {
        persistenceManagerFactory.getPersistenceManager().createHouseholdInDatabaseIfNotExists(authenticatedHousehold);
    }

    public void addProfile(Household household, Profile profile){
        persistenceManagerFactory.getPersistenceManager().addNewProfileToDatabase(household, profile);
    }
    public MutableLiveData<HashMap<String,Profile>> getListOfProfiles(Household household){
        return persistenceManagerFactory.getPersistenceManager().getProfileList(household);
    }

    public MutableLiveData<String> getToastMessage(){
        return persistenceManagerFactory.getPersistenceManager().getToastMessage();
    }


}