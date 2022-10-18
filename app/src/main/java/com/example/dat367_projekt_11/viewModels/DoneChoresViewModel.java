package com.example.dat367_projekt_11.viewModels;


import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.view.ChoreAdapterDataModel;

/**
 *This class represents the ViewModel for DoneChoresView.
 * @author Hanna Harnesk
 */


public class DoneChoresViewModel extends ViewModel implements ChoreAdapterDataModel {


    @Override
    public void moveChore(Chore chore,Household household) {
        household.markChoreAsAvailable(chore);
    }
}