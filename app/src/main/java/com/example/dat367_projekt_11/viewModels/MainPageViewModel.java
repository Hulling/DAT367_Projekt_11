package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.example.dat367_projekt_11.view.ChoreAdapterDataModel;

public class MainPageViewModel extends ViewModel implements ChoreAdapterDataModel {
    private final MutableLiveData<String> mText;
    private final PersistenceManagerFactory persistenceManagerFactory;
    private final Household household;

    public MainPageViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue(""/*chorelist */);
        this.persistenceManagerFactory= new PersistenceManagerFactory();
        this.household = new Household();

    }

    public LiveData<String> getText() {
        return mText;
    }

    @Override
    public void moveChore(Chore chore,Household household) {
        household.markChoreAsDone(chore);
    }



}
