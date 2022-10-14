package com.example.dat367_projekt_11;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Profile;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ListenerTest {
    private final Chore chore = new Chore("diska", "diskar disk", 10);
    private final Profile profile = new Profile("hanna");
    private final ArrayList<Chore> donechoreslist = new ArrayList<Chore>();


    @Test
    public void completeChoreTest() {
        chore.completeChore(); //sätt boolean till completed (true)
        donechoreslist.add(chore);
        profile.addToDoneChores(chore); //lägg till sysslan i donechoreslistan -> subscriba chore
        chore.unCompleteChore(); //sätt boolean till uncompleted (false) -> notifysubscribers -> remove
        chore.completeChore();


        assertEquals(donechoreslist, profile.getDoneChores());
    }
}

