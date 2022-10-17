package com.example.dat367_projekt_11.models;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * The PersistenceManager class is the only class that communicate with Firebase. It implement a way
 * to read and write to Firebase Realtime Database and use firebase authenticator to login and register
 * new user.
 *
 * The class is inspired from https://medium.com/firebase-tips-tricks/how-to-create-a-clean-firebase-authentication-using-mvvm-37f9b8eb7336
 * The class uses information in https://firebase.google.com/docs/database/android/read-and-write
 *
 * @author  Kristin Hulling
 * @version 1.0
 * @since   2022-10-16
 */

public class FirebasePersistenceManager implements PersistenceManager {

    private static final FirebasePersistenceManager instance = new FirebasePersistenceManager();
    private final FirebaseAuth firebaseAuth;
    private MutableLiveData<String> toastMessage;
    private final DatabaseReference myRef;

    /**
     * Private class constructor to implement Singelton pattern. Gets instance of firebaseAuth and
     * firebaseDatabase.
     */
    private FirebasePersistenceManager() {
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.toastMessage = new MutableLiveData<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://dat367-projekt-11-default-rtdb.europe-west1.firebasedatabase.app/");
        this.myRef = database.getReference("users");

    }

    /**
     * Singelton pattern.
     */
    public static FirebasePersistenceManager getInstance(){
        return instance;
    }


    /**
     * Returns a mutableLivedata object of with a message that the view will display.
     */
    public MutableLiveData<String> getToastMessage (){
        if (toastMessage == null) {
            toastMessage = new MutableLiveData<>();
        }
        return toastMessage;
    }

    /**
     * Uses firebaseauth to sign in the household. If the task is successful then it gets the uid, name
     * email from the current signed in household and return that household. If the task fails
     * the mutable livedata  toastmessage will be set to a message about what caused the fail.
     *
     * The method return a mutablelivedata object that is set to the created household.
     *
     * @return The the logged in user.
     *
     * @param inEmail The email the user writes in the textfield.
     * @param inPassword The password the user writes in the textfield.
     */
    public MutableLiveData<Household> login(String inEmail, String inPassword) {
        MutableLiveData<Household> authenticatedHouseholdMutableLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithEmailAndPassword(inEmail, inPassword).addOnCompleteListener(authTask -> {
            if (authTask.isSuccessful()) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    String uid = firebaseUser.getUid();
                    String name = firebaseUser.getDisplayName();
                    String email = firebaseUser.getEmail();
                    Household household = new Household(uid, email, name);
                    authenticatedHouseholdMutableLiveData.setValue(household);
                }
            } else {
                toastMessage.setValue(authTask.getException().getMessage());
                Log.d("LOG", authTask.getException().getMessage());
            }
        });
        return authenticatedHouseholdMutableLiveData;
    }

    /**
     * Uses firebaseauth to register a household. If the task is successful then the households
     * name sets to what the user has written in the textfield. If the task fails
     * the mutable livedata  toastmessage will be set to a message about what caused the fail.
     *
     * @param inEmail The email the user writes in the textfield.
     * @param inPassword The password the user writes in the textfield.
     * @param inHouseholdName The householdName the user writes in the textfield.
     */

    public MutableLiveData<Household> register(String inEmail, String inPassword, String inHouseholdName) {
        MutableLiveData<Household> registerHouseholdMutableLiveData = new MutableLiveData<>();
        firebaseAuth.createUserWithEmailAndPassword(inEmail, inPassword)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                        if (firebaseUser != null) {
                            String uid = firebaseUser.getUid();
                            String name = firebaseUser.getDisplayName();
                            String email = firebaseUser.getEmail();
                            Household household = new Household(uid, email, name);
                            createHousehold(household);

                            registerHouseholdMutableLiveData.setValue(household);
                        }
                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                .setDisplayName(inHouseholdName).build();

                        firebaseUser.updateProfile(profileUpdates)
                                .addOnCompleteListener(task1 -> {
                                    if (task1.isSuccessful()) {
                                        Log.d(TAG, "User profile updated.");
                                    }
                                });
                    }
                    else {
                        toastMessage.setValue(task.getException().getMessage());
                    }
                });
        return registerHouseholdMutableLiveData;
    }

    public void createHousehold(Household household){
        myRef.child(household.getUid()).setValue(household);
    }

    /**
     * Writes the signed in household to database if it not exists.
     *
     * @param authenticatedHousehold The signed in household.
     */
    public void createHouseholdInDatabaseIfNotExists(Household authenticatedHousehold) {
        myRef.child(authenticatedHousehold.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Log.d(TAG, "User already exist");
                } else {
                    myRef.child(authenticatedHousehold.getUid()).setValue(authenticatedHousehold);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "postComments:onCancelled", error.toException());
            }
        });
    }

    /**
     * Reads from database to get the profile list from the household.
     *
     * The method returns a mutablelivedata object that is set to the list of profiles.
     *
     * @return The list of profiles from the household.
     *
     * @param household The household that we reads the profile list from
     */
    public MutableLiveData<HashMap<String,Profile>> getProfileList(Household household){
        MutableLiveData<HashMap<String, Profile>> listOfProfiles = new MutableLiveData<>();
        myRef.child(household.getUid()).child("profileList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Profile profile = postSnapshot.getValue(Profile.class);
                    household.addProfile(profile);
                }
                listOfProfiles.setValue(household.getProfileList());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "loadPost:onCancelled", error.toException());
            }
        });
        return listOfProfiles;
    }

    /**
     * Adds profile to a household in the database.
     *
     * @param household Household to be added a new profile.
     * @param profile Profile to add to household.
     */
    public void addNewProfileToDatabase(Household household, Profile profile){
        myRef.child(household.getUid()).child("profileList").child(profile.getName()).setValue(profile);
    }

    /**
     * Reads from database to get a household with the uid from the param. The method is used to
     * get the current signed in household.
     *
     * The method returns a mutablelivedata object that is set to the household with the uid of the
     * param.
     *
     * @return household
     *
     * @param householdUid A households user id.
     */
    public MutableLiveData<Household> getHousehold(String householdUid){
        MutableLiveData<Household> householdMutableLiveData = new MutableLiveData<>();
       myRef.child(householdUid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Household household = snapshot.getValue(Household.class);
                householdMutableLiveData.setValue(household);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "loadPost:onCancelled", error.toException());
            }
        });
        return householdMutableLiveData;
    }

    /**
     * Adds chore to a household in the database.
     *
     * @param household Household to be added a new profile.
     * @param chore chore to add to household.
     */
    public void addChoreToHousehold(Household household, Chore chore){
        myRef.child(household.getUid()).child("householdChores").child(chore.getName()).setValue(chore);
    }

    public void addDoneChoreToProfile(Household household, Profile profile, Chore chore){
        myRef.child(household.getUid()).child("householdChores").child(chore.getName()).removeValue();
        myRef.child(household.getUid()).child("profileList").child(profile.getName()).child("doneChores").child(chore.getName()).setValue(chore);
    }
    public void addPointsToProfile(Household household, Profile profile, Integer points){
        myRef.child(household.getUid()).child("profileList").child(profile.getName()).child("currentPoints").setValue(points);
    }

}
