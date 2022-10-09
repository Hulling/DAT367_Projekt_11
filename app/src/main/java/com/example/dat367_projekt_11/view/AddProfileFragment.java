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
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.viewModels.LoginViewModel;

public class AddProfileFragment extends Fragment {
    private FragmentAddProfileBinding binding;
    private LoginViewModel loginViewModel;
    private Button addBtn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddProfileBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);

        setAddBtnOnClick(binding.getRoot());

        return binding.getRoot();
    }

    private void setAddBtnOnClick(View view) {
        addBtn = view.findViewById(R.id.createProfileBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.getAuthenticatedHousehold().observe(getViewLifecycleOwner(), authenticatedUser -> {
                    loginViewModel.addProfile(authenticatedUser, new Profile(loginViewModel.getProfileName().getValue()));
                });
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_addProfileFragment_to_mainActivity);
            }
        });
    }
}