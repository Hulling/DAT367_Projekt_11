package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.view.MoveChore;
/**
 *This class represents the ViewModel for MainPageView.
 * @author Hanna Harnesk
 * @author Malin Kihlström
 */


public class MainPageViewModelMove extends ViewModel implements MoveChore {


    @Override
    public void moveChore(Chore chore,Household household) {
        household.markChoreAsDone(chore);
    }


}
