package com.example.dat367_projekt_11.viewModels;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.view.ChoreAdapterDataModel;
import com.example.dat367_projekt_11.view.CreateChoreView;
import com.example.dat367_projekt_11.view.DoneChoresView;

import java.util.HashMap;

public class DoneChoresViewModel extends ViewModel implements ChoreAdapterDataModel {
    private Household household;
    private final MutableLiveData<String> mText;



    public DoneChoresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("@string/done_ChoreTitle");
        this.household = new Household();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setCurrentProfile(Profile profile){
        household.setCurrentProfile(profile);
    }

    @Override
    public void moveChore(Chore chore) {
        household.markChoreAsAvailable(chore);
    }
}