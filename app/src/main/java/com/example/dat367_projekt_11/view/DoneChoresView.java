package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.databinding.FragmentDonechoresBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.FacadeGetHousehold;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.viewModels.DoneChoresViewModel;

import java.util.HashMap;

public class DoneChoresView extends Fragment {
    private FragmentDonechoresBinding binding;
    private DoneChoresViewModel doneChoresViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDonechoresBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        doneChoresViewModel = new ViewModelProvider(this).get(DoneChoresViewModel.class);
        binding.setDoneChoresViewModel(doneChoresViewModel);
        doneChoresViewModel.setCurrentProfile(getProfile());
        populateData(getProfile());
        return binding.getRoot();
    }

    private void populateData(Profile profile) {

        if(profile.getDoneChores()!=null){
            ChoreAdapter choreAdapter = new ChoreAdapter(profile.getDoneChores(), getContext(), doneChoresViewModel);
            binding.setChoreAdapter(choreAdapter);
        }
        else{
            ChoreAdapter choreAdapter = new ChoreAdapter(new HashMap<>(), getContext(), doneChoresViewModel);
            binding.setChoreAdapter(choreAdapter);
        }
   /*     FacadeGetHousehold facadeGetHousehold = new FacadeGetHousehold(getContext());
        facadeGetHousehold.getHousehold().observe(getViewLifecycleOwner(), household -> {
            if(household.getCurrentProfile().getDoneChores()!=null){
                ChoreAdapter choreAdapter = new ChoreAdapter(household.getCurrentProfile().getDoneChores(), getContext(),doneChoresViewModel, household);
                binding.setChoreAdapter(choreAdapter);
            }
            else{
                ChoreAdapter choreAdapter = new ChoreAdapter(new HashMap<String, Chore>(), getContext(), doneChoresViewModel, household);
                binding.setChoreAdapter(choreAdapter);
            }
        });*/
    }


    private Profile getProfile(){
        Profile profile = (Profile) getActivity().getIntent().getSerializableExtra("PROFILE");
        return  profile;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
