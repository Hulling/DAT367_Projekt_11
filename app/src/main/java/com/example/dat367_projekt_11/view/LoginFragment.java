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
import com.example.dat367_projekt_11.databinding.FragmentLoginBinding;
import com.example.dat367_projekt_11.models.ConfigHandler;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.viewModels.AuthViewModel;

/**
 * The class represent the sign in view for the user.
 *
 * @author  Kristin Hulling
 * @version 1.0
 * @since   2022-10-16
 */

public class LoginFragment extends Fragment {

    private AuthViewModel authViewModel;
    private FragmentLoginBinding binding;
    private ConfigHandler configHandler;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        binding.setAuthViewModel(authViewModel);
        setLoginBtnOnAction(binding.getRoot());
        return binding.getRoot();
    }

    private void setLoginBtnOnAction(View view) {
        Button loginButton = view.findViewById(R.id.login);
        loginButton.setOnClickListener(view1 -> {
            String email = authViewModel.getEmail().getValue();
            String password = authViewModel.getPassword().getValue();
            if (email !=null && password !=null) {
                signIn(email, password);
            } else {
                Toast.makeText(getContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void signIn(String email, String password) {
        authViewModel.login(email, password);
        authViewModel.getAuthenticatedHousehold().observe(getViewLifecycleOwner(), authenticatedHousehold -> {
            createNewHousehold(authenticatedHousehold);
            configHandler = new ConfigHandler(getContext());
            configHandler.writeCurrentUser(authenticatedHousehold);
            goToProfileFragment();
        });
        authViewModel.getToastMessage().observe(getViewLifecycleOwner(), toastMessage ->{
            Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
        });
    }

    private void createNewHousehold(Household authenticatedHousehold) {
        authViewModel.createHousehold(authenticatedHousehold);
    }

    private void goToProfileFragment() {
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_loginFragment_to_profileFragment);
    }
}

