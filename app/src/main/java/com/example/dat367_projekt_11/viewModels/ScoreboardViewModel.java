package com.example.dat367_projekt_11.viewModels;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.dat367_projekt_11.models.ScoreboardModel;


/**
 * The purpose of this class is to communicate between ScoreboardFragment and ScoreboardModel.
 *
 * @author Pauline Björk
 */

public class ScoreboardViewModel extends AndroidViewModel {
    public ScoreboardViewModel(@NonNull Application application) {
        super(application);
    }

    private String rankingOfScoresTwoText;

    private static final ScoreboardModel rankingOfScoresText = new ScoreboardModel();
    private static final String rankingOfScores = rankingOfScoresText.getRankingOfScoresText();

    public void onLeaderboardClicked(){

        rankingOfScoresTwoText = rankingOfScores;

    }

    public String getRankingOfScoresTwoText(){return rankingOfScoresTwoText;}


}

