package com.example.dat367_projekt_11.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentWinnerPopUpBinding;
import com.google.android.material.resources.TextAppearance;

/**
 * Malin Kihlström 2022-10
 * https://stackoverflow.com/questions/28837231/how-to-center-popupwindow
 * https://stackoverflow.com/questions/5944987/how-to-create-a-popup-window-popupwindow-in-android
 */
public class WinnerPopUp extends Fragment {
    private WinnerPopUp winnerPopUp;
    private FragmentWinnerPopUpBinding binding;


    public static WinnerPopUp newInstance() {return new WinnerPopUp();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //TODO inte klart
        binding.winnerText.setText("hej");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_winner_pop_up, container, false);
    }
}