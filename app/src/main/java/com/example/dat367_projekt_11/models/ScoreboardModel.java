package com.example.dat367_projekt_11.models;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;

import java.util.Objects;


public class ScoreboardModel {


    /*private static final Profile currentPoints = new Profile();
    private static int memberScore = currentPoints.getCurrentPoints();*/


    public SharedPreferences getSharedPreferences(String pref, int i) {
        return null;
    }

    /*så här såg det ut innan:
    int bestOne = preferences.getInt("points1", 0);
    int bestTwo = preferences.getInt("points2", 0);*/


    /*private String rankingOfScoresText = "hejdå";*/


    @SuppressLint("SetTextI18n")
    public String rankProfiles() {



        /*getSharedPreferences("PREF", +0);*/

        SharedPreferences preferences = getSharedPreferences("PREF", 0);
        int memberScore = preferences != null ? preferences.getInt("memberScore", 5/*memberScore*/) : 5;
        int bestOne = preferences != null ? preferences.getInt("points1", 8) : 8;
        int bestTwo = preferences != null ? preferences.getInt("points2", 4) : 4;
        int bestThree = preferences != null ? preferences.getInt("points3", 2) : 2;
        String bestOneName = "Hanna";
        String bestTwoName = "Malin";
        String bestThreeName = "Kristin";



        if (memberScore > bestThree) {
            bestThree = memberScore;
            /*SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", bestThree);
            editor.apply();*/

        }

        if (memberScore > bestTwo) {
            int temp = bestTwo;
            bestTwo = memberScore;
            bestThree = temp;
            /*SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", bestThree);
            editor.putInt("points2", bestTwo);
            editor.apply();*/
        }

        if (memberScore > bestOne) {
            int temp = bestOne;
            bestOne = memberScore;
            bestTwo = temp;
            /*SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points2", bestTwo);
            editor.putInt("points1", bestOne);
            editor.apply();*/
        }


        String rankingOfScoresText = "#1" + " " + "Hanna" + " " + bestOne + "p" + "\n" + "\n" +
                "#2" + " " + "Kristin" + " " + bestTwo + "p" + "\n" + "\n" +
                "#3" + " " + "Malin" + " " + bestThree + "p";


        return rankingOfScoresText;

    }


    public String getRankingOfScoresText(){return rankProfiles();}


}
