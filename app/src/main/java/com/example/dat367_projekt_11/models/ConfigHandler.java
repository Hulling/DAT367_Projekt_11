package com.example.dat367_projekt_11.models;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
// From https://developer.android.com/training/data-storage/app-specific
public class ConfigHandler {

    private Context context;

    public ConfigHandler(Context context) {
        this.context = context;
    }

    public void writeCurrentUser(Household household) {
        String householdUid = household.getUid();
        byte[] byteArrray = householdUid.getBytes();
        try (FileOutputStream fos = context.openFileOutput("textfile.txt", Context.MODE_PRIVATE)) {
            fos.write(byteArrray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        } finally {
            String contents = stringBuilder.toString();
            return contents;
        }
    }
}

