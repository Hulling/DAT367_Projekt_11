package com.example.dat367_projekt_11.view;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentScoreboardBinding;
import com.example.dat367_projekt_11.models.ScoreboardModel;
import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;

public class ScoreboardFragment extends Fragment{


    private ScoreboardViewModel fViewModel;

    private FragmentScoreboardBinding binding;

    /*private String testText = "printa fan";*/

    /*private static final ScoreboardViewModel rankingOfScoresTwoText = new ScoreboardViewModel();
    private static final String rankingOfScoresTwo = rankingOfScoresTwoText.getRankingOfScoresTwoText();*/

    public static ScoreboardFragment newInstance() {
        return new ScoreboardFragment();
    }

    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {;

        binding = FragmentScoreboardBinding.inflate(inflater, container, false);
        fViewModel = new ViewModelProvider(this ).get(ScoreboardViewModel.class);

        fViewModel.onLeaderboardClicked();
        setRankingText(fViewModel.getRankingOfScoresTwoText());

        return binding.getRoot(); /*inflater.inflate(R.layout.fragment_scoreboard, container, false);*/
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

/*private final ScoreboardModel rankProfiles = new ScoreboardModel();
    private numberOne = bestOne.getBestOne;*/

    public void setRankingText(String s){

        TextView scoresText = binding.getRoot().findViewById(R.id.Scores);
        
        scoresText.setText(s);

    }

}