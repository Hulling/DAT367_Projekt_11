package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;

import java.util.Objects;

public class CreateChoreViewModel extends ViewModel {


    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> description = new MutableLiveData<>();
    public MutableLiveData<Integer> points = new MutableLiveData<>();//
    private MutableLiveData<Chore> userMutableLiveData;
    private Household household;

    public MutableLiveData<Chore> getChore() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }
    public void onDoneClicked() {
        try {
            Chore chore = new Chore(name.getValue(), description.getValue(), points.getValue());
            userMutableLiveData.setValue(chore);
            chore.setName(name.getValue());
            chore.setDescription(description.getValue());
            chore.setPoints(points.getValue());
            addChore(chore);
        } catch (NullPointerException e){
            System.out.println("null");
        }

    }
    private MutableLiveData<String> getName () {
        return Objects.requireNonNull(this.name);
        }

    private MutableLiveData<String> getDescription () {
        return description;
    }

    private MutableLiveData<Integer> getPoints () {
        return points;}


    private void addChore(Chore chore) {
            household.addChoreToList(chore);
        }

    public void onClickRB1() {
        points.setValue(10);
    }
    public void onClickRB2(){
        points.setValue(20);
    }
    public void onClickRB3(){
        points.setValue(30);
    }

}

