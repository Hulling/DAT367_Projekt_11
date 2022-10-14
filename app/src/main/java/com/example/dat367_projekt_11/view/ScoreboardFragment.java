package com.example.dat367_projekt_11.view;

import androidx.lifecycle.MutableLiveData;
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
import android.widget.Toast;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentScoreboardBinding;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.models.ScoreboardModel;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;

import org.w3c.dom.Text;



import java.text.BreakIterator;
import java.util.Objects;

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

        binding = FragmentScoreboardBinding.inflate(inflater, container, false);
        fViewModel = new ViewModelProvider(this ).get(ScoreboardViewModel.class);
        System.out.println("Kommer den hit?");
        fViewModel.onLeaderboardClicked();

        System.out.println("Hit då?");

        return binding.getRoot(); /*inflater.inflate(R.layout.fragment_scoreboard, container, false);*/
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

/*private final ScoreboardModel rankProfiles = new ScoreboardModel();
    private numberOne = bestOne.getBestOne;*/

}