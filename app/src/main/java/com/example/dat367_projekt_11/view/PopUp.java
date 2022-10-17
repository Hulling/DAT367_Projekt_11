package com.example.dat367_projekt_11.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentPopUpBinding;
import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;

/**
 * @author Malin Kihlström
 */
public class PopUp extends Fragment {
    private TextView textView;
    private FragmentPopUpBinding binding;
    private ScoreboardViewModel scoreboardViewModel;

    public static PopUp newInstance() {
        return new PopUp();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pop_up, container, false);
    }


}