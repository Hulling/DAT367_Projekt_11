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
import com.example.dat367_projekt_11.databinding.FragmentAddProfileBinding;
import com.example.dat367_projekt_11.models.FacadeCurrentHousehold;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.viewModels.AuthViewModel;

/**
 * The class represent the view for adding a new profile to the household.
 *
 * @author  Kristin Hulling
 */

public class AddProfileFragment extends Fragment {
    private FragmentAddProfileBinding binding;
    private AuthViewModel authViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddProfileBinding.inflate(inflater, container, false);
        authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        binding.setAuthViewModel(authViewModel);
        setAddBtnOnClick(binding.getRoot());
        return binding.getRoot();
    }

    private void setAddBtnOnClick(View view) {
        Button addBtn = view.findViewById(R.id.createProfileBtn);
        addBtn.setOnClickListener(v -> {
            Profile profile = new Profile(authViewModel.getProfileName().getValue());
            FacadeCurrentHousehold facadeCurrentHousehold = new FacadeCurrentHousehold(getContext());
            facadeCurrentHousehold.getHousehold().observe(getViewLifecycleOwner(), household -> {
               authViewModel.addProfile(household, profile);
            });
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_addProfileFragment_to_mainActivity);
        });
    }
}