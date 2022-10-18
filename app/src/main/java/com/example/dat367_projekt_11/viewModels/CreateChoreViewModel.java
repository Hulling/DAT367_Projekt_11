package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.ConfigHandler;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.example.dat367_projekt_11.view.CreateChoreView;

import java.util.Objects;

/**
 * This class respresents the ViewModel for the page where the user creates a chore.
 * @author Malin Kihlström
 *
 */

public class CreateChoreViewModel extends ViewModel {

    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<String> description = new MutableLiveData<>();
    private MutableLiveData<Chore> userMutableLiveData;
    private final CreateChoreView createChoreView = new CreateChoreView();

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


}

