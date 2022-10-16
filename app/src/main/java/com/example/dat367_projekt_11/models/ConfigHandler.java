package com.example.dat367_projekt_11.models;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * The ConfigHandler class is a class that writes and read from a text files. It is used for writing
 * the current signed in user locally.
 *
 *The class methods is taken from https://developer.android.com/training/data-storage/app-specific
 *
 * @author  Kristin Hulling
 * @version 1.0
 * @since   2022-10-16
 */

public class ConfigHandler {

    private final Context context;

    /**
     * Class constructor that inits the context.
     */
    public ConfigHandler(Context context) {
        this.context = context;
    }

    /**
     * The method writes a user id to a textfile
     *
     * @param household An household that will be written in text file.
     */
    public void writeCurrentUser(Household household) {
        String householdUid = household.getUid();
        byte[] byteArrray = householdUid.getBytes();
        try (FileOutputStream fos = context.openFileOutput("textfile.txt", Context.MODE_PRIVATE)) {
            fos.write(byteArrray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method reads a user id from a text file
     * @return User id
     */
    public String getCurrentUser() {
        FileInputStream fis = null;
        try {
            fis = context.openFileInput("textfile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        }
        return stringBuilder.toString();
    }
}


