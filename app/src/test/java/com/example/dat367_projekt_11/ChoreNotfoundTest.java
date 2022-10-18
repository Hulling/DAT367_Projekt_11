package com.example.dat367_projekt_11;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;

import org.junit.Test;

public class ChoreNotfoundTest {
    Chore chore = new Chore("test","test",10);
    Household household = new Household("test","test","test");

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


}
