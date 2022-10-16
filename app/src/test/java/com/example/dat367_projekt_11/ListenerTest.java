package com.example.dat367_projekt_11;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.Profile;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;

public class ListenerTest {
    private final Chore chore = new Chore("diska", "diskar disk", 10);
    private final Household household = new Household("Hannas","hanna.harnesk","hannshus");
    private final Profile profile = new Profile("hanna");
    private final HashMap<String, Chore> householdChoresCopy = new HashMap<String,Chore>();
    private final HashMap<String, Chore> doneChoresCopy = new HashMap<String,Chore>();

    @Test
    public void addChoreToHousehold(){
        household.addChore(chore);
        householdChoresCopy.put(chore.getName(),chore);
        assertEquals(householdChoresCopy,household.getHouseholdChores());
    }

    @Test
    public void addChoreToDoneChores(){
        profile.addToDoneChores(chore);
        doneChoresCopy.put(chore.getName(),chore);
        assertEquals(doneChoresCopy,profile.getDoneChores());
    }

    @Test
    public void getCurrentProfile(){
        household.setCurrentProfile(profile);
        assertEquals(household.getCurrentProfile(), profile);
    }

    @Test
    public void addProfileToHousehold(){
        household.addProfile(profile);
        household.setCurrentProfile(profile);
        assertEquals(profile, household.getCurrentProfile());
    }

    @Test
    public void removeChoreFromList(){
        profile.addToDoneChores(chore);
        profile.removeFromDoneChores(chore);
        assertEquals(doneChoresCopy,profile.getDoneChores());
    }

    @Test
    public void markChoreAsDone(){
        household.setCurrentProfile(profile);
        household.addProfile(profile);
        household.addChore(chore);
        household.markChoreAsDone(chore);
        assertEquals(householdChoresCopy,household.getHouseholdChores());
    }

    @Test
    public void markChoreAsDoneDoneList(){
        household.setCurrentProfile(profile);
        household.addProfile(profile);
        household.addChore(chore);
        household.markChoreAsDone(chore);
        doneChoresCopy.put(chore.getName(), chore);
        assertEquals(doneChoresCopy,household.getCurrentProfile().getDoneChores());
    }

    @Test
    public void markChoreAsAvailable(){
        household.setCurrentProfile(profile);
        household.addProfile(profile);
        household.addChore(chore);
        household.markChoreAsDone(chore);
        householdChoresCopy.put(chore.getName(), chore);
        household.markChoreAsAvailable(chore);
        assertEquals(householdChoresCopy,household.getHouseholdChores());
    }

}

