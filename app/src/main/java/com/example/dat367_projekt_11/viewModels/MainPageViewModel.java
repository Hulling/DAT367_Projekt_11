package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.example.dat367_projekt_11.view.ChoreAdapterDataModel;

import java.util.HashMap;

public class MainPageViewModel extends ViewModel implements ChoreAdapterDataModel {
    private PersistenceManagerFactory persistenceManagerFactory;

    public MainPageViewModel() {
        this.persistenceManagerFactory= new PersistenceManagerFactory();
    }

    @Override
    public HashMap<String, Chore> getChoreModellist() {
        HashMap<String, Chore> choreModelList = new HashMap<>();
        /*choreModelList.add(new Chore("malin", "avaliable chore", 300000));
        choreModelList.add(new Chore("malin", "available chore", 300000));
        choreModelList.add(new Chore("malin", "available chore", 300000));*/

        //choreModelList = household.getHouseholdChores();
        return choreModelList;
    }



}
