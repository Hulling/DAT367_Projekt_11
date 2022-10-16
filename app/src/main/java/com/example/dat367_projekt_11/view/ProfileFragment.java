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
import com.example.dat367_projekt_11.databinding.FragmentProfileBinding;
import com.example.dat367_projekt_11.models.FacadeCurrentHousehold;
import com.example.dat367_projekt_11.viewModels.AuthViewModel;

import java.util.HashMap;

public class ProfileFragment extends Fragment{
    private FragmentProfileBinding binding;
    private AuthViewModel authViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        binding.setAuthViewModel(authViewModel);
        Button addProfile = binding.getRoot().findViewById(R.id.addProfile);
        addProfile.setOnClickListener(v ->
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_profileFragment_to_addProfileFragment));

        populateData();
        return binding.getRoot();
    }

    private void populateData() {
        FacadeCurrentHousehold facadeCurrentHousehold = new FacadeCurrentHousehold(getContext());
        facadeCurrentHousehold.getHousehold().observe(getViewLifecycleOwner(), household -> {
            if(household.getProfileList()==null){
                ProfileAdapter profileAdapter = new ProfileAdapter(new HashMap<>(), getContext());
                binding.setProfileAdapter(profileAdapter);
            }
            else{
                authViewModel.getListOfProfiles(household).observe(getViewLifecycleOwner(), listOfProfiles ->{
                    ProfileAdapter profileAdapter = new ProfileAdapter(listOfProfiles, getContext());
                    binding.setProfileAdapter(profileAdapter);
                });
            }
        });
    }

}