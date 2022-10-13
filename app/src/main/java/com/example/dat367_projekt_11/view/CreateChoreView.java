package com.example.dat367_projekt_11.view;

import androidx.annotation.IdRes;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dat367_projekt_11.databinding.FragmentCreateChorePageBinding;
import com.example.dat367_projekt_11.databinding.FragmentLoginBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.viewModels.CreateChoreViewModel;
import com.example.dat367_projekt_11.R;

import java.util.Objects;

public class CreateChoreView extends Fragment {
    private Button doneButton;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CreateChoreViewModel createChoreViewModel;
    private FragmentCreateChorePageBinding binding;

    public static CreateChoreView newInstance() {
        return new CreateChoreView();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createChoreViewModel = new ViewModelProvider(this).get(CreateChoreViewModel.class);
        // TODO: Use the ViewModel
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateChorePageBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        createChoreViewModel = new ViewModelProvider(this).get(CreateChoreViewModel.class);
        binding.setCreateChoreViewModel(createChoreViewModel);
        createChoreViewModel.getChore().observe(getViewLifecycleOwner(), new Observer<Chore>() {


            public void onChanged(@Nullable Chore chore) {
                if (TextUtils.isEmpty(Objects.requireNonNull(chore).getName())) {
                    Toast.makeText(getActivity(),"Enter the chore's name",Toast.LENGTH_SHORT).show();
                }
                /*else {
                    binding.nameText.setText(chore.getName());
                }*/
                if (TextUtils.isEmpty(Objects.requireNonNull(chore).getDescription())) {
                    Toast.makeText(getActivity(),"Enter the chore's description",Toast.LENGTH_SHORT).show();
                }
                /*else {
                    binding.descriptionText.setText(chore.getDescription());

                }*/
                if (Objects.nonNull(radioGroup.getCheckedRadioButtonId())){
                    Toast.makeText(getActivity(),"Pick the chore's points",Toast.LENGTH_SHORT).show();
                }

            }
        });
        return binding.getRoot();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}