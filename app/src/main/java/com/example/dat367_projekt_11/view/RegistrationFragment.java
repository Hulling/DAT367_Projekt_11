package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentRegistrationBinding;
import com.example.dat367_projekt_11.viewModels.AuthViewModel;

public class RegistrationFragment extends Fragment {

    private FragmentRegistrationBinding binding;
    private AuthViewModel authViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        binding.setViewModel(authViewModel);
        setRegistrationBtnOnAction(binding.getRoot());
        return binding.getRoot();
    }

    private void setRegistrationBtnOnAction(View view) {
        Button loginButton = view.findViewById(R.id.registerBtn);

        loginButton.setOnClickListener(view1 -> {
            String email = authViewModel.getEmail().getValue();
            String password = authViewModel.getPassword().getValue();
            String householdName = authViewModel.getHouseholdName().getValue();
            if (email.length() > 0 && password.length() > 0) {
                register(email, password, householdName);
            } else {
                Toast.makeText(getContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void register(String email, String password, String householdName) {
        authViewModel.register(email, password, householdName);
        goToLoginFragment();
    }

    private void goToLoginFragment() {
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registrationFragment_to_loginFragment);
    }
}