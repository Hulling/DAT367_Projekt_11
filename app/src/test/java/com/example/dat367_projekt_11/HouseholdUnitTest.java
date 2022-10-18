package com.example.dat367_projekt_11;

import static org.junit.Assert.assertEquals;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.GetCurrentProfile;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.Profile;


import org.junit.Test;

import java.util.HashMap;

public class HouseholdUnitTest {
        private final Chore chore = new Chore("diska", "diskar disk", 10);
        private final Household household = new Household("Hannas","hanna.harnesk","hannshus");
        private final Profile profile = new Profile("hanna");
        private final HashMap<String, Chore> householdChoresCopy = new HashMap<String,Chore>();
        private final HashMap<String, Chore> doneChoresCopy = new HashMap<String,Chore>();
        private final HashMap<String, Profile> profileListTest = new HashMap<String, Profile>();
        GetCurrentProfile getCurrentProfile = GetCurrentProfile.getInstance();



        @Test
        public void getUidTest(){
            assertEquals("Hannas",household.getUid());
        }

        @Test
        public void setPasswordTest(){
            household.setPassword("hejhejhej");
            assertEquals("hejhejhej", household.getPassword());

        }

        @Test
        public void getHouseholdChoresTest(){
            household.addChore(chore);
            householdChoresCopy.put(chore.getName(),chore);
            assertEquals(householdChoresCopy,household.getHouseholdChores());
        }

        @Test
        public void setEmailTest(){
            household.setEmail("test.testar@gmail.com");
            assertEquals("test.testar@gmail.com", household.getEmail());
        }

        @Test
        public void setHouseholdNameTest(){
            household.setHouseholdName("testhousehold");
            assertEquals("testhousehold", household.getHouseholdName());
        }


        @Test
        public void addChoreToHouseholdTest(){
            household.addChore(chore);
            householdChoresCopy.put(chore.getName(),chore);
            assertEquals(householdChoresCopy,household.getHouseholdChores());
        }

        @Test
        public void addChoreToDoneChoresTest(){
            profile.addToDoneChores(chore);
            doneChoresCopy.put(chore.getName(),chore);
            assertEquals(doneChoresCopy,profile.getDoneChores());
        }



        @Test
        public void removeChoreFromListTest(){
            profile.addToDoneChores(chore);
            profile.removeFromDoneChores(chore);
            assertEquals(doneChoresCopy,profile.getDoneChores());
        }
/*
        @Test
        public void markChoreAsDoneTest(){
         //   household.setCurrentProfile(profile);
            household.addProfile(profile);
            household.addChore(chore);
            household.markChoreAsDone(chore);
            assertEquals(householdChoresCopy,household.getHouseholdChores());
        }*/

    /*    @Test
        public void markChoreAsDoneDoneListTest(){

            //household.setCurrentProfile(profile);
            household.addProfile(profile);
            household.addChore(chore);
            household.markChoreAsDone(chore);
            doneChoresCopy.put(chore.getName(), chore);
            assertEquals(doneChoresCopy,household.getCurrentProfile().getDoneChores());
        }

        @Test
        public void markChoreAsAvailableTest(){
           // household.setCurrentProfile(profile);
            household.addProfile(profile);
            household.addChore(chore);
            household.markChoreAsDone(chore);
            householdChoresCopy.put(chore.getName(), chore);
            household.markChoreAsAvailable(chore);
            assertEquals(householdChoresCopy,household.getHouseholdChores());
        }*/

        @Test
        public void addProfileListTest(){
            household.addProfile(profile);
            profileListTest.put(profile.getName(), profile);
            assertEquals(profileListTest,household.getProfileList());
        }

        @Test
        public void removeProfileTest(){
            household.addProfile(profile);
            household.deleteProfile(profile);
            assertEquals(profileListTest, household.getProfileList());
        }




}
