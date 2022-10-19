package com.example.dat367_projekt_11.viewModels;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.dat367_projekt_11.models.ScoreboardModel;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * The purpose of this class is to communicate between ScoreboardFragment and ScoreboardModel.
 *
 * @author Pauline Björk
 */

public class ScoreboardViewModel extends AndroidViewModel {
    public ScoreboardViewModel(@NonNull Application application) {
        super(application);
    }
    // TODO: Implement the ViewModel

    private String rankingOfScoresTwoText;

    private static final ScoreboardModel rankingOfScoresText = new ScoreboardModel();
    private static final String rankingOfScores = rankingOfScoresText.getRankingOfScoresText();


    public void onLeaderboardClicked(){

        rankingOfScoresTwoText = rankingOfScores;

    }

    public String getRankingOfScoresTwoText(){return rankingOfScoresTwoText;}


}

