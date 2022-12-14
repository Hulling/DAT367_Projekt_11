
package com.example.dat367_projekt_11;

import static org.junit.Assert.assertEquals;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.models.ScoreboardModel;

import org.junit.Test;

public class ScoreboardUnitTest {

    private final Profile profile = new Profile("Pelle");
    private final Chore chore = new Chore("Dammsuga","dammsug",10);
    private final ScoreboardModel scoreboardModel = new ScoreboardModel();

    @Test
    public void setProfileScore(){
        profile.addToDoneChores(chore);
        assertEquals(10,profile.getCurrentPoints());
    }

    @Test
    public void getBestOne(){
        scoreboardModel.rankProfiles(20);
        assertEquals(20, scoreboardModel.bestOne);
    }

    @Test
    public void getBestOne2(){
        scoreboardModel.rankProfiles(20);
        assertEquals(8, scoreboardModel.bestTwo);
        assertEquals(4, scoreboardModel.bestThree);
    }

    @Test
    public void getBestOne3(){
        scoreboardModel.rankProfiles(20);
        assertEquals(4, scoreboardModel.bestThree);
    }

    @Test
    public void getBestTwo(){
        scoreboardModel.rankProfiles(6);
        assertEquals(6, scoreboardModel.bestTwo);
    }


    @Test
    public void getBestTwo2(){
        scoreboardModel.rankProfiles(6);
        assertEquals(4, scoreboardModel.bestThree);
    }


    @Test
    public void getBestThree(){
        scoreboardModel.rankProfiles(3);
        assertEquals(3, scoreboardModel.bestThree);
    }



}
