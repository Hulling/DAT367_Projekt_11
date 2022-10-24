package com.example.dat367_projekt_11.models;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;



/**
 * The purpose of this class is to find the three profiles
 * with the highest scores in the household and rank them from 1 to 3.
 *
 * @author Pauline Björk
 */

public class ScoreboardModel {



    public int bestOne;
    public int bestTwo;
    public int bestThree;


    /** Ranks profiles by comparing scores */
    @SuppressLint("SetTextI18n")
    public String rankProfiles(int ps) {


        int profileScore = ps;
        bestOne = 8;
        bestTwo = 4;
        bestThree = 2;

        String profileName = "Pauline";
        String bestOneName = "Hanna";
        String bestTwoName = "Malin";
        String bestThreeName = "Kristin";


        /* Looks if the current members points is a larger int than the current third place */
        if (profileScore > bestThree) {
            bestThree = profileScore;
            bestThreeName = profileName;
        }

        /* Looks if the current members points is a larger int than the current second place */
        if (profileScore > bestTwo) {
            int temp = bestTwo;
            bestTwo = profileScore;
            bestThreeName = bestTwoName;
            bestTwoName = profileName;
            bestThree = temp;
        }

        /* Looks if the current members points is a larger int than the current first place */
        if (profileScore > bestOne) {
            int temp = bestOne;
            bestOne = profileScore;
            bestTwoName = bestOneName;
            bestOneName = profileName;
            bestTwo = temp;
        }

        /*Makes string that will be shown in the scoreboard fragment */
        String rankingOfScoresText = "#1" + " " + bestOneName + " " + bestOne + "p" + "\n" + "\n" +
                                     "#2" + " " + bestTwoName + " " + bestTwo + "p" + "\n" + "\n" +
                                     "#3" + " " + bestThreeName + " " + bestThree + "p";


        return rankingOfScoresText;

    }

    /** Is used to create object of ScoreboardModel in ScoreaboardViewModel */
    public String getRankingOfScoresText(){return rankProfiles(10);}



}
