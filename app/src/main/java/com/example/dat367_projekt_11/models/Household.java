package com.example.dat367_projekt_11.models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;

/**
 * This class represents the households of TidyApp
 */
public class Household implements IsCompleteListener { //lyssnar på chores boolean{
    private String householdName;
    private HashMap<String, Profile> profileList;
    private String password;
    private String email;
    private Profile currentProfile;

    private String uid;
    private HashMap<String, Chore> householdChores;//ArrayList<Chore> householdChores; //ev. hashmap, bara chores med is.complete = false
  //  private ArrayList<AvailableChoresListener> listeners;
    //måste vi inte skapa listan av householdchores och listeners någonstans för att kunna lägga till i?
//kolla att sakerna är nollskilda, objekt required non null.
    //design by contract

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
        chore.subscribe(this);
        householdChores.put(chore.getName(), chore);
      // notifyListeners(); // --> notifiera
    }

    /**
     * Removes chore from household chores.
     * @param chore the chore to be removed from household chores.
     */

    private void removeChoreFromList(Chore chore){ //när en chore tas bort meddelas eller görs uavailable alla som implementerar choreliststatuslistener
            if (chore.isComplete()){
                chore.unsubscribe(this);
                householdChores.remove(chore);
               // notifyListeners(); //--> notifiera

        }
    }

    //defensiv inkopiering, defensiv utkopiering -> kan göra så man får en wrapper som gör unmodifiable. blir körningsfel om så händer. läs collectionsklassen.

    public HashMap<String, Chore> getHouseholdChores() { //jättemuterbar obs! collections. java utility collections.-> unmodifiable, ex of chores. kan ej modifiera listan
    /**
     * Gets the household chores
     * @return the household chores
     */
    public List<Chore> getHouseholdChores() { //jättemuterbar obs! collections. java utility collections.-> unmodifiable, ex of chores. kan ej modifiera listan
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
     * Sets the list of profiles.
     * @param profileList the list of profiles to be set.
     */
//TODO behöver vi verkligen denna?
    public void setProfileList(List<Profile> profileList){this.profileList = profileList;}

    public HashMap<String, Profile> getProfileList() {
    /**
     * Gets the profiles
     * @return the profiles
     */
    public List<Profile> getProfileList() {
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

    /**
     * Updates list of household chores whenever a chore is completed
     * @param chore the chore that has been completed
     */
    @Override
    public void update(Chore chore) {  //updateras householdchores -> available chores -> lyssnar på chores boolean
        this.removeChoreFromList(chore);
    }

    public void setCurrentProfile(Profile profile){
        currentProfile = profile;
    }

    private Profile getCurrentProfile(){
        return currentProfile;
    }

    public void addChoreToList(Chore chore){
        householdChores.add(chore);
    }

  /*  private void subscribe(AvailableChoresListener listener) { //broadcast
        listeners.add(listener);
    }*/

/*    private void notifyListeners() {
        for (AvailableChoresListener listener : listeners) {  //broadcast
            listener.update(householdChores);
        }

    }*/

}
