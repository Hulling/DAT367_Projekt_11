package com.example.dat367_projekt_11.models;

public class GetCurrentProfile {
    private static final GetCurrentProfile instance = new GetCurrentProfile();

    private Profile profile;

    private GetCurrentProfile() {
        this.profile = new Profile();
    }

    public static GetCurrentProfile getInstance(){
        return instance;
    }

    public Profile getProfile(){
        return profile;
    }
    public void setProfile(Profile setProfile){
        profile = setProfile;
    }
}
