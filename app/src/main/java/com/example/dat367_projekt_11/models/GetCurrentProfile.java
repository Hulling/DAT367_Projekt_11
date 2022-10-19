package com.example.dat367_projekt_11.models;

/**
 * The GetCurrentProfile is used to easy access which is the current profile of the application.
 * The current profile is set when the user clicks on a profile.
 *
 * @author  Kristin Hulling
 */

public class GetCurrentProfile {
    private static final GetCurrentProfile instance = new GetCurrentProfile();
    private Profile profile;

    /**
     * Private class constructor to implement Singleton pattern.
     */
    private GetCurrentProfile() {
        this.profile = new Profile();
    }

    /**
     * Singelton pattern.
     */
    public static GetCurrentProfile getInstance(){
        return instance;
    }

    /**
     * Gets the Profile
     * @return The profile
     */
    public Profile getProfile(){
        return profile;
    }

    /**
     * Sets the Profile
     * @param setProfile the profile that will get set
     */
    public void setProfile(Profile setProfile){
        profile = setProfile;
    }
}
