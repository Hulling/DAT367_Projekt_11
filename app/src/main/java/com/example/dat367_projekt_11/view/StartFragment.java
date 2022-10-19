package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.dat367_projekt_11.R;

/**
 * The class represent the first view the user sees. The user can either sign in or register.
 *
 * The navigation in the application is inspired from:
 * https://itnext.io/android-navigation-component-in-java-621d7f8561b used to navigate
 *
 * @author  Kristin Hulling
 */
public class StartFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        setSignInBtnOnAction(view);
        setRegisterBtnOnAction(view);
        return view;
    }
    private void setSignInBtnOnAction(View view){
        Button gotoLogin = view.findViewById(R.id.signInBtn);
        gotoLogin.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_startFragment_to_loginFragment));
    }

    private void setRegisterBtnOnAction(View view){
        Button gotoRegistration = view.findViewById(R.id.regBtn);
        gotoRegistration.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_startFragment_to_registrationFragment));
    }
}