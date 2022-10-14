package com.example.dat367_projekt_11.models;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.List;


public class Household{
    private String householdName;
    private List<Profile> profileList;
    private String password;
    private String email;


    public String getUid() {
        return uid;
    }

    private String uid;
    private List<Chore> householdChores;//ArrayList<Chore> householdChores; //ev. hashmap, bara chores med is.complete = false
  //  private ArrayList<AvailableChoresListener> listeners;
//kolla att sakerna är nollskilda, objekt required non null.
    //design by contract


    public Household(String uid, String email, String householdName) {
        this.uid = uid;
        this.email = email;
        this.householdName = householdName;
        this.householdChores = new ArrayList<Chore>();
        this.profileList = new ArrayList<>();
    }
    public Household() {}

   /* public FirebaseAuth getmAuth(){
        return  mAuth;
    }
    //returnera kopia? orginal kan mixtas med.*/

    @Exclude
    public boolean isNew, isCreated;

    public void setPassword(String password) {
        this.password = password;
    }

    public void addChoreToList(Chore chore) {
        householdChores.add(chore);
    }

    private void getCurrentProfile(){

    }

/*
   public void markChoreasDone(Chore chore){
        boolean found = householdChores.remove(chore);
        if(!found){
            throw new IllegalArgumentException("Chore not found" + chore);
        }
        this.getCurrentProfile().addToDoneChores(chore);
    }

    //facade för hela model. -> facaden som model i chore_card_fragment

    public void markChoreasAvailable(Chore chore){
        boolean found = getCurrentProfile().removeFromDoneChores();
        if(!found){
            throw new IllegalArgumentException("Chore not found" + chore);
        }
        this.householdChores.add(chore);
    }
*/


    private void removeChoreFromList(Chore chore){
            if (chore.isComplete()){
                householdChores.remove(chore);


        }
    }

    //defensiv inkopiering, defensiv utkopiering -> kan göra så man får en wrapper som gör unmodifiable. blir körningsfel om så händer. läs collectionsklassen.

    public List<Chore> getHouseholdChores() { //jättemuterbar obs! collections. java utility collections.-> unmodifiable, ex of chores. kan ej modifiera listan
        return householdChores;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setProfileList(List<Profile> profileList){this.profileList = profileList;}

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void addProfile(Profile profile){
        profileList.add(profile);
    }

    public void deleteProfile(Profile profile){
        profileList.remove(profile);
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }




  /*  public void setCurrentProfile(Profile profile) {

    }*/

}
