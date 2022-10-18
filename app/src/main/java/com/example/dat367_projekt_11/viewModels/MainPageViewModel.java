package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.example.dat367_projekt_11.view.ChoreAdapterDataModel;
/**
 *This class represents the ViewModel for MainPageView.
 * @author Hanna Harnesk
 * @author Malin Kihlström
 */


public class MainPageViewModel extends ViewModel implements ChoreAdapterDataModel {


    @Override
    public void moveChore(Chore chore,Household household) {
        household.markChoreAsDone(chore);
    }


}
