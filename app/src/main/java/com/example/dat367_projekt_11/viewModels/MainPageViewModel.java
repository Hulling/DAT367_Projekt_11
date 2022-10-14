package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.example.dat367_projekt_11.view.ChoreAdapterDataModel;

import java.util.ArrayList;
import java.util.List;

public class MainPageViewModel extends ViewModel implements ChoreAdapterDataModel {
    private final MutableLiveData<String> mText;
    private Household household;
    private PersistenceManagerFactory persistenceManagerFactory;

    public MainPageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(""/*chorelist */);
        this.persistenceManagerFactory= new PersistenceManagerFactory();
    }

    public LiveData<String> getText() {
        return mText;
    }




    @Override
    public List<Chore> getChoreModellist() {
        List<Chore> choreModelList = new ArrayList<>();
        choreModelList.add(new Chore("malin", "avaliable chore", 300000));
        choreModelList.add(new Chore("malin", "available chore", 300000));
        choreModelList.add(new Chore("malin", "available chore", 300000));

        //choreModelList = household.getHouseholdChores();
        return choreModelList;
    }

/*
    @Override
    public void onCheckboxClicked(Chore chore) {
        if (!chore.isComplete()) {
            chore.completeChore();

        }
    }*/


}
