package com.example.dat367_projekt_11;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.dat367_projekt_11.models.ConfigHandler;
import com.example.dat367_projekt_11.models.Household;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ConfighandlerUnitTest {
    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    @Test
    public void useAppContext() {
        // Context of the app under test.
        assertEquals("com.example.dat367_projekt_11", appContext.getPackageName());
    }
    @Test
    public void configHandlerReadWrite() {
        Household household = new Household("uid", "email", "name");
        ConfigHandler configHandler = new ConfigHandler(appContext);
        configHandler.writeCurrentUser(household);
        assertEquals(configHandler.getCurrentUser(), household.getUid());
    }
}