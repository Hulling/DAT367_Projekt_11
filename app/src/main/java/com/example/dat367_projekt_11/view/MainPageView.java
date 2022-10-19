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
import com.example.dat367_projekt_11.databinding.FragmentMainpageBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.FacadeCurrentHousehold;
import com.example.dat367_projekt_11.viewModels.MainPageViewModelMove;

import java.util.HashMap;

public class MainPageView extends Fragment {
  //  private Button createButton; ?
    private FragmentMainpageBinding binding;
    private MainPageViewModelMove mainPageViewModel;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainpageBinding.inflate(inflater, container, false);

        mainPageViewModel = new ViewModelProvider(this).get(MainPageViewModelMove.class);
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
        FacadeCurrentHousehold facadeGetHousehold = new FacadeCurrentHousehold(getContext());
        facadeGetHousehold.getHousehold().observe(getViewLifecycleOwner(), household -> {
            ChoreAdapter choreAdapter;
            if(household.getHouseholdChores()!=null){
                choreAdapter = new ChoreAdapter(household.getHouseholdChores(), getContext(), mainPageViewModel, household);
            }
            else{
                choreAdapter = new ChoreAdapter(new HashMap<String, Chore>(), getContext(), mainPageViewModel, household);
            }
            binding.setChoreAdapter(choreAdapter);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}