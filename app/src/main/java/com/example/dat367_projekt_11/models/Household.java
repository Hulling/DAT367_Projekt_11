package com.example.dat367_projekt_11.models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;

/**
 * This class represents the households of TidyApp
 */
public class Household {
    private String householdName;
    private HashMap<String, Profile> profileList;
    private String password;
    private String email;
    private Profile currentProfile;

    private String uid;
    private HashMap<String, Chore> householdChores;//ArrayList<Chore> householdChores; //ev. hashmap, bara chores med is.complete = false

    /**
     *
     * @param uid
     * @param email
     * @param householdName
     */
    public Household(String uid, String email, String householdName) {
        this.uid = uid;
        this.email = email;
        this.householdName = householdName;
        this.householdChores = new HashMap<>();
        this.profileList = new HashMap<>();
        this.currentProfile = new Profile();
    }
    public Household() {}

   /* public FirebaseAuth getmAuth(){
        return  mAuth;
    }
    //returnera kopia? orginal kan mixtas med.*/

    @Exclude
    public boolean isNew, isCreated;

    /**
     * Sets the password
     * @param password the password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Adds chores to household chores.
     * @param chore the chore to be added to household chores.
     */
    public void addChore(Chore chore){ //när en chore görs available meddelas alla som im. chorelist status listener
        householdChores.put(chore.getName(), chore);
    }

    /**
     * Removes chore from household chores.
     * @param chore the chore to be removed from household chores.
     */

    private void removeChoreFromList(Chore chore){ //när en chore tas bort meddelas eller görs uavailable alla som implementerar choreliststatuslistener
            if (chore.isComplete()){
                householdChores.remove(chore);


        }
    }

    //defensiv inkopiering, defensiv utkopiering -> kan göra så man får en wrapper som gör unmodifiable. blir körningsfel om så händer. läs collectionsklassen.

    /**
     * Gets the household chores
     * @return the household chores
     */

    public HashMap<String, Chore> getHouseholdChores() {//jättemuterbar obs! collections. java utility collections.-> unmodifiable, ex of chores. kan ej modifiera listan
        return householdChores;
    }

    /**
     * Gets the password
     * @return the password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Sets the email
     * @param email the email to be set.
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the email
     * @return the email
     */

    public String getEmail() {
        return email;
    }

    /**
     * Gets the household name
     * @return the household name
     */
    public String getHouseholdName() {
        return householdName;
    }
    /**
     * @return TODO besvik vad den gör
     */
    public String getUid() {
        return uid;
    }

    //public void setProfileList(List<Profile> profileList){this.profileList = profileList;}

    /**
     * Gets the profiles
     * @return the profiles
     */
    public HashMap<String, Profile> getProfileList() {
        return profileList;
    }

    /**
     * Adds profile to list of profiles
     * @param profile the profile to be added to the list
     */
    public void addProfile(Profile profile){
        profileList.put(profile.getName(), profile);
    }

    /**
     * Deletes profile from list of profiles
     * @param profile the profile to be deleted from the list
     */
    public void deleteProfile(Profile profile){
        profileList.remove(profile);
    }

    /**
     * Sets household name
     * @param householdName the household name to be set
     */
    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }


    public void setCurrentProfile(Profile profile){
        currentProfile = profile;
    }

    public Profile getCurrentProfile(Profile profile){return currentProfile;}


}
