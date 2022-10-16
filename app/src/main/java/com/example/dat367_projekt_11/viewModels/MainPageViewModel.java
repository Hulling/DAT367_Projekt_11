package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.FacadeGetHousehold;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.example.dat367_projekt_11.view.ChoreAdapterDataModel;

import java.util.HashMap;

public class MainPageViewModel extends ViewModel implements ChoreAdapterDataModel {
    private final MutableLiveData<String> mText;
    private Household household; //hanna behöver få tag på household
    private PersistenceManagerFactory persistenceManagerFactory;

    public MainPageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(""/*chorelist */);
        this.persistenceManagerFactory= new PersistenceManagerFactory();
        this.household = new Household(); //hanna, detta fungerar ej.
    }

    public LiveData<String> getText() {
        return mText;
    }

    @Override
    public void moveChore(Chore chore) {
        household.markChoreAsDone(chore);
    }


}
