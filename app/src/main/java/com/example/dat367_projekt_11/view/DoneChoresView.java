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
import com.example.dat367_projekt_11.models.GetCurrentProfile;
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
       // binding.setLifecycleOwner(this);
        doneChoresViewModel = new ViewModelProvider(this).get(DoneChoresViewModel.class);
        binding.setDoneChoresViewModel(doneChoresViewModel);
        populateData();
        return binding.getRoot();
    }



    private void populateData() {
        GetCurrentProfile getCurrentProfile = GetCurrentProfile.getInstance();
        FacadeGetHousehold facadeGetHousehold = new FacadeGetHousehold(getContext());
        facadeGetHousehold.getHousehold().observe(getViewLifecycleOwner(), household -> {
            if(getCurrentProfile.getProfile().getDoneChores()!=null){
                ChoreAdapter choreAdapter = new ChoreAdapter(getCurrentProfile.getProfile().getDoneChores(), getContext(),doneChoresViewModel, household);
                binding.setChoreAdapter(choreAdapter);
            }
            else{
                ChoreAdapter choreAdapter = new ChoreAdapter(new HashMap<String, Chore>(), getContext(), doneChoresViewModel, household);
                binding.setChoreAdapter(choreAdapter);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
