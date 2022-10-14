package com.example.dat367_projekt_11;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.Profile;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ListenerTest {
    private final Chore chore = new Chore("diska", "diskar disk", 10);
    private final Profile profile = new Profile("hanna");
    private final ArrayList<Chore> donechoreslist = new ArrayList<Chore>();
    private final Household hannasHousehold = new Household("hanna", "hanna.harnesk@live.se","Hannas household");
    private final ArrayList<Chore> availableChorelist = new ArrayList<Chore>();


/*    @Test
    public void completeChoreTest() {
        chore.completeChore(); //sätt boolean till completed (true)
        donechoreslist.add(chore); //samma syssla i godtycklig lista för jämförelse.
        profile.addToDoneChores(chore); //lägg till sysslan i donechoreslistan -> subscriba chore
        chore.unCompleteChore(); //sätt boolean till uncompleted (false) -> notifysubscribers -> remove
        chore.completeChore();


        assertEquals(donechoreslist, profile.getDoneChores());
    }*/

    @Test
    public void addChoreToHouseholdTest(){
        hannasHousehold.addChoreToList(chore); //lägg till en syssla i households availablechorelist
        availableChorelist.add(chore); //lägg till syssla i godtycklig lista

        assertEquals(availableChorelist, hannasHousehold.getHouseholdChores());

    }

    @Test
    public void addChoreToDoneChoresList(){
        chore.completeChore(); //boolean sätts till true
        donechoreslist.add(chore); //lägg till sysslan i god. donelist
        profile.addToDoneChores(chore); //lägg till sysslan i profilens listen -> profil subscribar på sysslan.
        assertEquals(donechoreslist, profile.getDoneChores());

    }



    @Test
    public void completeChoreTest(){
        hannasHousehold.addChoreToList(chore); //lägg till en syssla i households availablechorelist
        availableChorelist.add(chore); //lägg till syssla i godtycklig lista
        chore.completeChore(); //boolean sätts till true -> försvinner ur householdchores
        availableChorelist.remove(chore); //ta bort sysslan i godt. avalist.

        assertEquals(availableChorelist, hannasHousehold.getHouseholdChores()); //är listorna lika?
    }

/*
    @Test
    public void completeChoretoDoneChores(){
        hannasHousehold.addProfile(profile); //lägg till profil i household
        hannasHousehold.addChoreToList(chore); //lägg till en syssla i households availablechorelist ->subscribe på chore
        chore.completeChore(); //boolean sätts till true -> försvinner ur householdchores
        donechoreslist.add(chore); //lägg till sysslan i god. donelist
        profile.addToDoneChores(chore); //lägg till sysslan i profilens listen -> profil subscribar på sysslan.
        assertEquals(donechoreslist, profile.getDoneChores()); //är listorna lika?
    }*/


    @Test
    public void moveChoreBetweenLists(){
        hannasHousehold.addProfile(profile); //lägg till profil i household
        hannasHousehold.addChoreToList(chore); //lägg till en syssla i households availablechorelist ->subscribe på chore
        chore.completeChore(); //boolean sätts till true -> försvinner ur householdchores
        profile.addToDoneChores(chore); //lägg till sysslan i profilens lista -> profil subscribar på sysslan.
        chore.unCompleteChore(); //boolean sätts för chore till false -> notifierar household & profile ->tas bort från profile och läggs till i household
        availableChorelist.add(chore); //sysslan finns i god. ava-chore-list
        assertEquals(availableChorelist, hannasHousehold.getHouseholdChores()); //är sysslan i householdchoresList?

    }

    @Test
    public void moveChoreBetweenLists2(){
        hannasHousehold.addProfile(profile); //lägg till profil i household
        hannasHousehold.addChoreToList(chore); //lägg till en syssla i households availablechorelist ->subscribe på chore
        chore.completeChore(); //boolean sätts till true -> försvinner ur householdchores
        profile.addToDoneChores(chore); //lägg till sysslan i profilens lista -> profil subscribar på sysslan.
        chore.unCompleteChore(); //boolean sätts för chore till false -> notifierar household & profile ->tas bort från profile och läggs till i household
        donechoreslist.remove(chore); //godtycklig done-chore-list är tom
        assertEquals(donechoreslist,profile.getDoneChores());// är profiles donechorelist tom?


    }






}

