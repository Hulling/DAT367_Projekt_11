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
    }
    public Household() {}

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
    public void addChore(Chore chore){
        householdChores.put(chore.getName(), chore);
    }

    /**
     * Removes chore from household chores.
     * @param chore the chore to be removed from household chores.
     */

    private void removeChoreFromList(Chore chore){
        householdChores.remove(chore.getName()); //detta måste vara risky AF, key bör vara annat än namnet?? typ hash?
    }

    /**
     * Relocates chore from hashmap of available chores to hashmap of done chores.
     * @param chore the chore to be relocated from available chores to done chores.
     */


    public void markChoreAsDone(Chore chore){
        GetCurrentProfile getCurrentProfile = GetCurrentProfile.getInstance();
        boolean found = householdChores.containsKey(chore.getName());
        if(!found){
            throw new IllegalArgumentException("Chore not found" + chore);
        }
        else{
            this.removeChoreFromList(chore);
            getCurrentProfile.getProfile().addToDoneChores(chore);
        }

    }
    /**
     * Relocates chore from hashmap of done chores to hashmap of available chores.
     * @param chore the chore to be relocated from done chores to available chores.
     */


    public void markChoreAsAvailable(Chore chore){
        GetCurrentProfile getCurrentProfile = GetCurrentProfile.getInstance();
        boolean found = getCurrentProfile.getProfile().getDoneChores().containsKey(chore.getName());
        if(!found){
            throw new IllegalArgumentException("Chore not found" + chore);
        }else{
            getCurrentProfile.getProfile().getDoneChores().remove(chore.getName());
            this.addChore(chore);
        }

    }




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
        profileList.remove(profile.getName());
    }

    /**
     * Sets household name
     * @param householdName the household name to be set
     */
    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }



}
