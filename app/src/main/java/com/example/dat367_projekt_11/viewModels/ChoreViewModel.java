package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.AvailableChoresListener;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;


import java.util.ArrayList;

public class ChoreViewModel extends ViewModel implements AvailableChoresListener {
    private Chore chore;
    private Household household;
    private MutableLiveData<Chore> userMutableLiveData;




    public MutableLiveData<Chore> getHousehold() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }




    //tar in arraylist med information för varje chore
    @Override
    public void update(ArrayList<Chore> choreList) {

    }



}