
package com.example.dat367_projekt_11;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.models.ScoreboardModel;

public class ScoreboardUnitTest {

    private final Profile profile = new Profile("Pelle");
    private final Chore chore = new Chore("Dammsuga","dammsug",10);
    private final ScoreboardModel scoreboardModel = new ScoreboardModel();

    @Test
    public void setProfileScore(){
        profile.addToDoneChores(chore);
        assertEquals(10,profile.getCurrentPoints());
    }

    /*@Test
    public void getProfileName(){
        profile.getName();
        assertEquals("Pelle", "Pelle");
    }*/

    @Test
    public double getProfileName(){
        scoreboardModel.rankProfiles();
        getProfileName();
        assertEquals("Pelle", getProfileName());
        return 0;
    }

    @Test
    public double getProfileScore(){
        scoreboardModel.rankProfiles();
        getProfileScore();
        assertEquals(10, getProfileScore());
        return 0;
    }




}
