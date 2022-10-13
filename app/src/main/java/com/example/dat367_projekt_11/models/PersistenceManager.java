package com.example.dat367_projekt_11.models;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class PersistenceManager implements FirebasePersistenceManager { //Svårt att testa denna klass, kolla upp mocking

    private FirebaseAuth firebaseAuth;
    private MutableLiveData<String> toastMessage;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    public PersistenceManager() {
        this.firebaseAuth = FirebaseAuth.getInstance(); // svårt att testa, kommentarer
        this.toastMessage = new MutableLiveData<>();
        this.database = FirebaseDatabase.getInstance("https://dat367-projekt-11-default-rtdb.europe-west1.firebasedatabase.app/");
        this.myRef = database.getReference("users");

    }

    public MutableLiveData<Household> login(String inEmail, String inPassword) {
        MutableLiveData<Household> authenticatedHouseholdMutableLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithEmailAndPassword(inEmail, inPassword).addOnCompleteListener(authTask -> {
            if (authTask.isSuccessful()) {
                boolean isNewUser = authTask.getResult().getAdditionalUserInfo().isNewUser();
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    String uid = firebaseUser.getUid();
                    String name = firebaseUser.getDisplayName();
                    String email = firebaseUser.getEmail();
                    Household household = new Household(uid, name, email);
                    household.isNew = isNewUser;
                    authenticatedHouseholdMutableLiveData.setValue(household);
                }
            } else {
                Log.d("LOG", authTask.getException().getMessage());
            }
        });
        return authenticatedHouseholdMutableLiveData;
    }

    public void register(String email, String password, String householdName) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(householdName).build();

                            firebaseUser.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Log.d(TAG, "User profile updated.");
                                            }
                                        }
                                    });
                        }
                        else {
                            toastMessage.setValue("Registration failure " + task.getException().getMessage());
                        }
                    }
                });
    }

    public void logOut() {
        firebaseAuth.signOut();
    }

    public MutableLiveData<Household> createHouseholdInFirestoreIfNotExists(Household authenticatedHousehold) {
        MutableLiveData<Household> newHouseholdMutableLiveData = new MutableLiveData<>();
        myRef.child(authenticatedHousehold.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    myRef.child(authenticatedHousehold.getUid()).child("username").setValue(authenticatedHousehold);
                    newHouseholdMutableLiveData.setValue(authenticatedHousehold);
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                }
            }
        });
        return newHouseholdMutableLiveData;
    }

    public MutableLiveData<List<Profile>> addNewProfileToDatabase(Household household, Profile profile){
        MutableLiveData<List<Profile>> newListOfProfiles = new MutableLiveData<>();
        myRef.child(household.getUid()).child("profiles").child(profile.getName()).setValue(profile);
        household.addProfile(profile);
        newListOfProfiles.setValue(household.getProfileList());
        return newListOfProfiles;
    }
    public MutableLiveData<List<Profile>> getListFromFirestore(Household household){
        MutableLiveData<List<Profile>> newListOfProfiles = new MutableLiveData<>();
        myRef.child(household.getUid()).child("profiles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot profileSnapPost: snapshot.getChildren()) {
                    Profile profile = profileSnapPost.getValue(Profile.class);
                    household.addProfile(profile);
                    newListOfProfiles.setValue(household.getProfileList());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "loadPost:onCancelled", error.toException());
            }
        });
        return newListOfProfiles;
    }
    public MutableLiveData<Profile> getChosenProfile(Household household, Profile inProfile){
        MutableLiveData<Profile> chosenProfile = new MutableLiveData<>();
        myRef.child(household.getUid()).child("profiles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot profileSnapPost: snapshot.getChildren()) {
                    Profile profile = profileSnapPost.getValue(Profile.class);
                    if(profile==inProfile){
                        chosenProfile.setValue(profile);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "loadPost:onCancelled", error.toException());
            }
        });
        return chosenProfile;
    }

}
