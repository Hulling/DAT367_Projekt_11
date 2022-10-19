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
import com.example.dat367_projekt_11.models.FacadeCurrentHousehold;
import com.example.dat367_projekt_11.models.ScoreboardModel;
import com.example.dat367_projekt_11.viewModels.AuthViewModel;
import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;

import java.util.HashMap;


/**
 * The purpose of this class is to call on the update of the ranking
 * when the scoreboard icon is pressed on the screen.
 *
 * @author Pauline Björk
 */

public class ScoreboardFragment extends Fragment{



    private ScoreboardViewModel fViewModel;

    private FragmentScoreboardBinding binding;

    public static ScoreboardFragment newInstance() {
        return new ScoreboardFragment();
    }


    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {;

        FacadeCurrentHousehold facadeGetHousehold = new FacadeCurrentHousehold(getContext());
        facadeGetHousehold.getHousehold().observe(getViewLifecycleOwner(), household -> {
            household.getProfileList();
        });

        binding = FragmentScoreboardBinding.inflate(inflater, container, false);
        fViewModel = new ViewModelProvider(this ).get(ScoreboardViewModel.class);


        fViewModel.onLeaderboardClicked();
        setRankingText(fViewModel.getRankingOfScoresTwoText());


        return binding.getRoot();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    /** Sets the String from ScoreboardModel in the TextView so is appears on the screen */
    public void setRankingText(String s){

        TextView scoresText = binding.getRoot().findViewById(R.id.Scores);
        
        scoresText.setText(s);

    }

}