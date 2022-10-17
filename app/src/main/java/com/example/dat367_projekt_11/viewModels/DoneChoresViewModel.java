package com.example.dat367_projekt_11.viewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.view.ChoreAdapterDataModel;

public class DoneChoresViewModel extends ViewModel implements ChoreAdapterDataModel {
    private final MutableLiveData<String> mText;


    public DoneChoresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("@string/done_ChoreTitle");
    }

    public LiveData<String> getText() {
        return mText;
    }

    @Override
    public void moveChore(Chore chore,Household household) {
        household.markChoreAsAvailable(chore);
    }
}