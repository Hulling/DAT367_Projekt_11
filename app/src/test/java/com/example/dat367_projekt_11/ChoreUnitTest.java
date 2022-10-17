package com.example.dat367_projekt_11;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dat367_projekt_11.models.Chore;

public class ChoreUnitTest {

    private final Chore chore = new Chore("Chore","this is a chore",30);

  /*  public ChoreUnitTest(Chore chore) {
        this.chore = chore;
    }
*/
    @Test
    public void getNameTest(){assertEquals("Chore",chore.getName());}

    @Test
    public void getDescriptionTest(){assertEquals("this is a chore", chore.getDescription());}

    @Test
    public void getPointsTest(){assertEquals(30, chore.getPoints());}

    @Test
    public void setNameTest(){
        chore.setName("test");
        assertEquals("test",chore.getName());
    }

    @Test
    public void setdescriptionTest(){
        chore.setDescription("Vacuum");
        assertEquals("Vacuum", chore.getDescription());
    }

    @Test
    public void setPointsTest(){
        chore.setPoints(40);
        assertEquals(40,chore.getPoints());
    }






}
