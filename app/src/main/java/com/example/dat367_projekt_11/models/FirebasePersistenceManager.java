package com.example.dat367_projekt_11.models;

import androidx.lifecycle.MutableLiveData;

public interface FirebasePersistenceManager {
    MutableLiveData<Household> login(String email, String password);
    void register(String email, String password, String householdName);
    void logOut();
    MutableLiveData<Household> createHouseholdInFirestoreIfNotExists(Household authenticatedHousehold);

}