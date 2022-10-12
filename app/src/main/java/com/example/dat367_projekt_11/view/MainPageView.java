package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentDonechoresBinding;
import com.example.dat367_projekt_11.databinding.FragmentMainpageBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.viewModels.DoneChoresViewModel;
import com.example.dat367_projekt_11.viewModels.MainPageViewModel;

import java.util.List;

public class MainPageView extends Fragment {
    private Button createButton;
    private FragmentMainpageBinding binding;
    private MainPageViewModel mainPageViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainpageBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        mainPageViewModel = new ViewModelProvider(this).get(MainPageViewModel.class);
        binding.setMainPageViewModel(mainPageViewModel);
        populateData();
        setCreateChoreButtonAction(binding.getRoot());
        return binding.getRoot();
    }

    private void setCreateChoreButtonAction(View view){
              Button createChoreButton = view.findViewById(R.id.createChoreButton);
              createChoreButton.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Navigation.findNavController(binding.getRoot()).navigate(R.id.action_navigation_mainpage_to_createChoreView);

                  }
              });
    }

    private void populateData() {
        List<Chore> choreModelList = mainPageViewModel.getChoreModellist();

        ChoreAdapter choreAdapter = new ChoreAdapter(choreModelList, getContext());
        binding.setChoreAdapter(choreAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}