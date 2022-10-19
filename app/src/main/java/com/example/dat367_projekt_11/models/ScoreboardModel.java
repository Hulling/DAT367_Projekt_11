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


    /** Ranks profiles by comparing scores */
    @SuppressLint("SetTextI18n")
    public String rankProfiles() {

        int memberScore = 10;
        int bestOne = 8;
        int bestTwo = 4;
        int bestThree = 2;

        String memberName = "Pauline";
        String bestOneName = "Hanna";
        String bestTwoName = "Malin";
        String bestThreeName = "Kristin";


        /* Looks if the current members points is a larger int than the current third place */
        if (memberScore > bestThree) {
            bestThree = memberScore;
            bestThreeName = memberName;
        }

        /* Looks if the current members points is a larger int than the current second place */
        if (memberScore > bestTwo) {
            int temp = bestTwo;
            bestTwo = memberScore;
            bestThreeName = bestTwoName;
            bestTwoName = memberName;
            bestThree = temp;
        }

        /* Looks if the current members points is a larger int than the current first place */
        if (memberScore > bestOne) {
            int temp = bestOne;
            bestOne = memberScore;
            bestTwoName = bestOneName;
            bestOneName = memberName;
            bestTwo = temp;
        }

        /*Makes string that will be shown in the scoreboard fragment */
        String rankingOfScoresText = "#1" + " " + bestOneName + " " + bestOne + "p" + "\n" + "\n" +
                                     "#2" + " " + bestTwoName + " " + bestTwo + "p" + "\n" + "\n" +
                                     "#3" + " " + bestThreeName + " " + bestThree + "p";


        return rankingOfScoresText;

    }

    /** Is used to create object of ScoreboardModel in ScoreaboardViewModel */
    public String getRankingOfScoresText(){return rankProfiles();}


}
