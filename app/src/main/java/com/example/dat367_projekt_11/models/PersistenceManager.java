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

import java.util.HashMap;

public class PersistenceManager implements FirebasePersistenceManager { //Svårt att testa denna klass, kolla upp mocking

    //https://medium.com/firebase-tips-tricks/how-to-create-a-clean-firebase-authentication-using-mvvm-37f9b8eb7336

    private static final PersistenceManager instance = new PersistenceManager(); // Singelton patterns

    private final FirebaseAuth firebaseAuth;
    private MutableLiveData<String> toastMessage;

    private final DatabaseReference myRef;

    public MutableLiveData<String> getToastMessage (){
        if (toastMessage == null) {
            toastMessage = new MutableLiveData<>();
        }
        return toastMessage;
    }


    private PersistenceManager() {
        this.firebaseAuth = FirebaseAuth.getInstance(); // svårt att testa, kommentarer
        this.toastMessage = new MutableLiveData<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://dat367-projekt-11-default-rtdb.europe-west1.firebasedatabase.app/");
        this.myRef = database.getReference("users");

    }

    public static PersistenceManager getInstance(){
        return instance;
    }

    public MutableLiveData<Household> login(String inEmail, String inPassword) {
        MutableLiveData<Household> authenticatedHouseholdMutableLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithEmailAndPassword(inEmail, inPassword).addOnCompleteListener(authTask -> {
            if (authTask.isSuccessful()) {
                //boolean isNewUser = authTask.getResult().getAdditionalUserInfo().isNewUser();
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    String uid = firebaseUser.getUid();
                    String name = firebaseUser.getDisplayName();
                    String email = firebaseUser.getEmail();
                    Household household = new Household(uid, email, name);
                    //household.isNew = isNewUser;
                    authenticatedHouseholdMutableLiveData.setValue(household);
                }
            } else {
                toastMessage.setValue(authTask.getException().getMessage());
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
                            toastMessage.setValue(task.getException().getMessage());
                        }
                    }
                });
    }

    public void logOut() {
        firebaseAuth.signOut();
    }

    public MutableLiveData<Household> createHouseholdInFirestoreIfNotExists(Household authenticatedHousehold) {
        MutableLiveData<Household> newHouseholdMutableLiveData = new MutableLiveData<>();
        myRef.child(authenticatedHousehold.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Log.d(TAG, "User already exist");
                } else {
                    myRef.child(authenticatedHousehold.getUid()).setValue(authenticatedHousehold);
                    newHouseholdMutableLiveData.setValue(authenticatedHousehold);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "postComments:onCancelled", error.toException());
            }
        });
        return newHouseholdMutableLiveData;
    }

    public void addNewProfileToDatabase(Household household, Profile profile){
        myRef.child(household.getUid()).child("profileList").child(profile.getName()).setValue(profile);
    }
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

    public void addChoreToHousehold(Household household, Chore chore){
        myRef.child(household.getUid()).child("householdChores").child(chore.getName()).setValue(chore);
    }

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

    public void addDoneChoreToProfile(Household household, Chore chore){
        myRef.child(household.getUid()).child("profileList").child(household.getCurrentProfile().getName()).child("doneChores").setValue(chore);
    }

/*    public void manageChore(Household household, Chore chore){*/
/*        household.markChoreAsAvailable(chore);*/
/*    }*/



}
