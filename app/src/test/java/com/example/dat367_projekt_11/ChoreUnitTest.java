package com.example.dat367_projekt_11;
import static org.junit.Assert.assertEquals;
import com.example.dat367_projekt_11.models.Chore;
import org.junit.Test;




public class ChoreUnitTest {
    private final Chore chore = new Chore("Chore","this is a chore", 40);


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
    } //OBS publik setter

    @Test
    public void setDescriptionTest(){
        chore.setDescription("Vacuum");
        assertEquals("Vacuum", chore.getDescription());
    }

    @Test
    public void setPointsTest(){
        chore.setPoints(50);
        assertEquals(50,chore.getPoints());
    }






}
