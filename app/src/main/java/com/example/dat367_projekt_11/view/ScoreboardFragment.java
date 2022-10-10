package com.example.dat367_projekt_11.view;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.models.ScoreboardModel;
import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;

import org.w3c.dom.Text;

import java.text.BreakIterator;
import java.util.Objects;

public class ScoreboardFragment extends Fragment {



    private ScoreboardViewModel mViewModel;

    String ranking = "hej";

    public static ScoreboardFragment newInstance() {
        return new ScoreboardFragment();
    }

    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {;

        mViewModel = new ViewModelProvider(this ).get(ScoreboardViewModel.class);
        System.out.println("Usch va detta är jobbigt");
        mViewModel.rankProfiles();
        makeScores(ranking);

        return inflater.inflate(R.layout.fragment_scoreboard, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    /*private final ScoreboardModel rankProfiles = new ScoreboardModel();
    private numberOne = bestOne.getBestOne;*/



    public void makeScores(String s){

        TextView scores;
        scores = (TextView) scores.findViewById(R.id.Scores);

        scores.setText(s);

    }

}