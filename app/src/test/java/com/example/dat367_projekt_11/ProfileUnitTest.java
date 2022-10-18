package com.example.dat367_projekt_11;

import static org.junit.Assert.assertEquals;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Profile;
import org.junit.Test;

import java.util.HashMap;
/**
 *This class represents unit-test for the methods in class Profile.
 * @author Hanna Harnesk
 */


public class ProfileUnitTest {

    private final Profile profile = new Profile("TestProfile");
    private final HashMap<String, Chore> doneChoresCopy = new HashMap<String,Chore>();
    private final Chore chore = new Chore("Test","Testar",10);


    @Test
    public void getNameTest(){assertEquals("TestProfile", profile.getName());}

    @Test
    public void getPointsTest(){
        assertEquals(0,profile.getCurrentPoints());
    }

    @Test
    public void setProfileNameTest(){
        profile.setName("Test2");
        assertEquals("Test2", profile.getName());
    }

    @Test
    public void addDoneChoresTest(){
        doneChoresCopy.put(chore.getName(),chore);
        profile.addToDoneChores(chore);
        assertEquals(doneChoresCopy,profile.getDoneChores());
    }

    @Test
    public void getCurrentPointsTest(){
       assertEquals(0,profile.getCurrentPoints());
    }

    @Test
    public void removeFromDoneChoresTest(){
        profile.addToDoneChores(chore);
        profile.removeFromDoneChores(chore);
        assertEquals(doneChoresCopy,profile.getDoneChores());

    }


    @Test
    public void increaseCurrentPointsTest(){
        profile.addToDoneChores(chore);
        assertEquals(10,profile.getCurrentPoints());
    }

    @Test
    public void decreaseCurrentPointsTest(){
        profile.addToDoneChores(chore);
        profile.removeFromDoneChores(chore);
        assertEquals(0,profile.getCurrentPoints());
    }




}
