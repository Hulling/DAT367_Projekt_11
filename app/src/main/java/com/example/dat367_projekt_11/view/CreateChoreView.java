package com.example.dat367_projekt_11.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dat367_projekt_11.databinding.FragmentCreateChorePageBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.FacadeGetHousehold;
import com.example.dat367_projekt_11.viewModels.CreateChoreViewModel;
import com.example.dat367_projekt_11.R;


public class CreateChoreView extends Fragment {
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
        //binding.setLifecycleOwner(this);
        createChoreViewModel = new ViewModelProvider(this).get(CreateChoreViewModel.class);
        binding.setCreateChoreViewModel(createChoreViewModel);

        setDoneButtonAction(binding.getRoot());
        return binding.getRoot();
    }

    private void setDoneButtonAction(View view){
        Button doneButton = view.findViewById(R.id.prominentDoneButton);
        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameField = createChoreViewModel.getName().getValue();
                String descField = createChoreViewModel.getDescription().getValue();
                int points = 10;
                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.radioButton: points = 10;break;
                    case R.id.radioButton2: points = 20;break;
                    case R.id.radioButton3: points = 30;break;
                }
                try {
                    Chore chore = new Chore(nameField,descField,points);
                    addChore(chore);
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.action_createChoreView_to_navigation_mainpage);
                }catch(NullPointerException n){
                    Toast.makeText(getContext() ,"Please fill in all empty fields", Toast.LENGTH_LONG).show();

                }
            }
        });


    }

    private void addChore(Chore chore){
        FacadeGetHousehold facadeGetHousehold = new FacadeGetHousehold(getContext());
        facadeGetHousehold.getHousehold().observe(getViewLifecycleOwner(), household -> {
            household.addChore(chore);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}