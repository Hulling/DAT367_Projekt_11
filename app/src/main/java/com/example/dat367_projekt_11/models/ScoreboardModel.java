package com.example.dat367_projekt_11.models;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.view.MainActivity;


public class ScoreboardModel extends AppCompatActivity {

   /* Behöver en instans av user för att få tillgång till alla profiler - Hanna och Malin*/

/*
    Profile currentPoints=new Profile();
    int memberScore = currentPoints.getCurrentPoints();

    TextView Scores;

    int best1;
    int best2;
    int best3;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scoreboard);

        Scores = (TextView) findViewById(R.id.Scores);

        SharedPreferences preferences = getSharedPreferences("PREF", +0);
        memberScore = preferences.getInt("memberScore", memberScore);
        best1 = preferences.getInt("points1", 0);
        best2 = preferences.getInt("points2", 0);
        best3 = preferences.getInt("points3", 0);

        if( memberScore > best3){
            best3 = memberScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", best3);
            editor.apply();
        }

        if( memberScore > best2){
            int temp = best2;
            best2 = memberScore;
            best3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", best3);
            editor.putInt("points2", best2);
            editor.apply();
        }

        if( memberScore > best1){
            int temp = best1;
            best1 = memberScore;
            best2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points2", best2);
            editor.putInt("points1", best1);
            editor.apply();
        }

        Scores.setText("#1" + best1 + "\n" +
                "#2" + best2 + "\n" +
                "#3" + best3);

    }*/

    /*@Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }*/

}
