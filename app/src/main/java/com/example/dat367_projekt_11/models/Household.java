package com.example.dat367_projekt_11.models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;


public class Household implements IsCompleteListener { //lyssnar på chores boolean{
    private String householdName;
    private HashMap<String, Profile> profileList;
    private String password;
    private String email;
    private Profile currentProfile;


    public String getUid() {
        return uid;
    }

    private String uid;
    private HashMap<String, Chore> householdChores;//ArrayList<Chore> householdChores; //ev. hashmap, bara chores med is.complete = false
  //  private ArrayList<AvailableChoresListener> listeners;
    //måste vi inte skapa listan av householdchores och listeners någonstans för att kunna lägga till i?
//kolla att sakerna är nollskilda, objekt required non null.
    //design by contract


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

    public void setPassword(String password) {
        this.password = password;
    }

    public void addChoreToList(Chore chore){ //när en chore görs available meddelas alla som im. chorelist status listener
        chore.subscribe(this);
        householdChores.put(chore.getName(), chore);
      // notifyListeners(); // --> notifiera
    }


    private void removeChoreFromList(Chore chore){ //när en chore tas bort meddelas eller görs uavailable alla som implementerar choreliststatuslistener
            if (chore.isComplete()){
                chore.unsubscribe(this);
                householdChores.remove(chore);
               // notifyListeners(); //--> notifiera

        }
    }

    //defensiv inkopiering, defensiv utkopiering -> kan göra så man får en wrapper som gör unmodifiable. blir körningsfel om så händer. läs collectionsklassen.

    public HashMap<String, Chore> getHouseholdChores() { //jättemuterbar obs! collections. java utility collections.-> unmodifiable, ex of chores. kan ej modifiera listan
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

    //public void setProfileList(List<Profile> profileList){this.profileList = profileList;}

    public HashMap<String, Profile> getProfileList() {
        return profileList;
    }

    public void addProfile(Profile profile){
        profileList.put(profile.getName(), profile);
    }

    public void deleteProfile(Profile profile){
        profileList.remove(profile);
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }
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


  /*  private void subscribe(AvailableChoresListener listener) { //broadcast
        listeners.add(listener);
    }*/

/*    private void notifyListeners() {
        for (AvailableChoresListener listener : listeners) {  //broadcast
            listener.update(householdChores);
        }

    }*/

}
