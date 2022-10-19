package com.example.dat367_projekt_11;

import static org.junit.Assert.assertEquals;

import com.example.dat367_projekt_11.models.GetCurrentProfile;
import com.example.dat367_projekt_11.models.Profile;

import org.junit.Test;

public class GetCurrentProfileTest {
    private GetCurrentProfile currentProfile = GetCurrentProfile.getInstance();
    private final Profile profile = new Profile("testprofile");


    @Test
    public void setCurrentprofileTest(){
        currentProfile.setProfile(profile);
        assertEquals(profile, currentProfile.getProfile());
    }
}
