package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentLoginBinding;
import com.example.dat367_projekt_11.models.User;
import com.example.dat367_projekt_11.viewModels.LoginViewModel;

import java.util.Objects;

public class LoginFragment extends Fragment implements View.OnClickListener{
    private Button signIn;

    private LoginViewModel loginViewModel;
    private FragmentLoginBinding binding;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);
        loginViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(@Nullable User loginUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getEmail())) {
                    Toast.makeText(getActivity(),"Enter an E-Mail Address",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getPassword())) {
                    Toast.makeText(getActivity(),"Enter a password",Toast.LENGTH_SHORT).show();
                }
                else {
                    binding.emailTextView.setText(loginUser.getEmail());
                    binding.passwordTextView.setText(loginUser.getPassword());
                }

            }
        });
        return binding.getRoot();
        /*View view = inflater.inflate(R.layout.fragment_login, container, false);

        signIn = view.findViewById(R.id.login);
        //signIn.setOnClickListener(this);

        return view;*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_profileFragment);
    }

}