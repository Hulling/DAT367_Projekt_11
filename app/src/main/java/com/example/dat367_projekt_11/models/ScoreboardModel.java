package com.example.dat367_projekt_11.models;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;

import java.util.Objects;



/**
 * The purpose of this class is to find the three profiles
 * with the highest scores in the household and rank them from 1 to 3.
 *
 * @author Pauline Björk
 */

public class ScoreboardModel {


    /*private static final Profile currentPoints = new Profile();
    private static int memberScore = currentPoints.getCurrentPoints();*/


    public SharedPreferences getSharedPreferences(String pref, int i) {
        return null;
    }

    /*så här såg det ut innan:
    int bestOne = preferences.getInt("points1", 0);
    int bestTwo = preferences.getInt("points2", 0);*/



    @SuppressLint("SetTextI18n")
    public String rankProfiles() {


        SharedPreferences preferences = getSharedPreferences("PREF", 0);
        int memberScore = preferences != null ? preferences.getInt("memberScore", 10/*memberScore*/) : 10;
        int bestOne = preferences != null ? preferences.getInt("points1", 8) : 8;
        int bestTwo = preferences != null ? preferences.getInt("points2", 4) : 4;
        int bestThree = preferences != null ? preferences.getInt("points3", 2) : 2;

        String memberName = "Pauline";
        String bestOneName = "Hanna";
        String bestTwoName = "Malin";
        String bestThreeName = "Kristin";


        /** Looks if the current members points is a larger int than the current third place */
        if (memberScore > bestThree) {
            bestThree = memberScore;
            bestThreeName = memberName;
        }

        /** Looks if the current members points is a larger int than the current second place */
        if (memberScore > bestTwo) {
            int temp = bestTwo;
            bestTwo = memberScore;
            bestThreeName = bestTwoName;
            bestTwoName = memberName;
            bestThree = temp;
        }

        /** Looks if the current members points is a larger int than the current first place */
        if (memberScore > bestOne) {
            int temp = bestOne;
            bestOne = memberScore;
            bestTwoName = bestOneName;
            bestOneName = memberName;
            bestTwo = temp;
        }

        /** Makes string that will be shown in the scoreboard fragment */
        String rankingOfScoresText = "#1" + " " + bestOneName + " " + bestOne + "p" + "\n" + "\n" +
                                     "#2" + " " + bestTwoName + " " + bestTwo + "p" + "\n" + "\n" +
                                     "#3" + " " + bestThreeName + " " + bestThree + "p";


        return rankingOfScoresText;

    }


    public String getRankingOfScoresText(){return rankProfiles();}


}
