package com.example.dat367_projekt_11.viewModels;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.view.ChoreAdapterDataModel;

import java.util.ArrayList;
import java.util.List;

public class DoneChoresViewModel extends ViewModel implements ChoreAdapterDataModel {
    private Profile profile;
    private final MutableLiveData<String> mText;

    public DoneChoresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("@string/done_ChoreTitle");
    }

    public LiveData<String> getText() {
        return mText;
    }


    @Override
    public List<Chore> getChoreModellist() { //returnerna listan av donechores;
       List<Chore> choreModelList = new ArrayList<>();
       Profile testProfile = new Profile("Hanna");
       Chore testChore = new Chore("malin", "Hej jag heter hanna och jag är världens cooolaste person", 300000);
       testProfile.addToDoneChores(testChore);
        // choreModelList.add(new Chore("malin", "Hej jag heter hanna och jag är världens cooolaste person", 300000));
        //choreModelList.add(new Chore("kristin", "Hej jag heter hanna och jag är världens cooolaste person", 300000));
        choreModelList = testProfile.getDoneChores();
        return choreModelList;
    }

}