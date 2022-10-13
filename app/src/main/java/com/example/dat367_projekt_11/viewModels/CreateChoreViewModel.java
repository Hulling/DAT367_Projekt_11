package com.example.dat367_projekt_11.viewModels;

import android.widget.EditText;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;

import java.util.Objects;

public class CreateChoreViewModel extends ViewModel {

    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<String> description = new MutableLiveData<>();
    private MutableLiveData<Chore> userMutableLiveData;
    private Household household;

    public MutableLiveData<Chore> getChore() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }
    public MutableLiveData<String> getName () {
        if(name == null) {
        name = new MutableLiveData<>();
        }
        return Objects.requireNonNull(this.name);
    }

    public MutableLiveData<String> getDescription () {
        if(description== null) {
            description = new MutableLiveData<>();
        }
        return description;
    }

    public void onDoneClicked(String name, String desc, int points) {
            Chore chore = new Chore(name, desc, points);
            addChore(chore);


    }


    private void addChore(Chore chore) {
            household.addChoreToList(chore);
        }


}

