package com.example.dat367_projekt_11;
import static org.junit.Assert.assertEquals;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;

import org.junit.Before;
import org.junit.Test;

/**
 *This class represents unit-test for the methods in class Chore.
 * @author Hanna Harnesk
 */


public class ChoreUnitTest {
    Chore chore;
    Chore choreInit;
    Household household = new Household("test","test","test");


    @Test
    public void constructorChoreTest(){
        choreInit = new Chore();
        assertEquals(choreInit.getName(), "init");

    }


    @Before
    public void init(){
         chore = new Chore("Chore","this is a chore", 40);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testException(){
        System.out.println("We are inside of the markChoreAsDone() method");
        household.markChoreAsDone(chore);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testException2(){
        System.out.println("We are inside of the markChoreAsDone() method");
        household.markChoreAsAvailable(chore);

    }


    @Test
    public void getNameTest(){assertEquals("Chore",chore.getName());}

    @Test
    public void getDescriptionTest(){assertEquals("this is a chore", chore.getDescription());}

    @Test
    public void getPointsTest(){assertEquals(40, chore.getPoints());}

    @Test
    public void setNameTest(){
        chore.setName("test");
        assertEquals("test",chore.getName());
    }

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
