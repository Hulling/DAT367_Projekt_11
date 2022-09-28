package com.example.dat367_projekt_11.viewModels;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.dat367_projekt_11.BR;
import com.example.dat367_projekt_11.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class LoginViewModel extends BaseObservable {
    private final User user;

    private final String successMessage = "Login was successful";
    private final String errorMessage = "Email or Password not valid";



    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel() {
        user = new User("","", "");
    }

    @Bindable
    private String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }


    public void onLoginClicked(){
        checkIfPasswordEmailTypedIn(getUserEmail(), getUserPassword());
        user.getmAuth().signInWithEmailAndPassword(getUserEmail(), getUserPassword()).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(
                            @NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            setToastMessage(successMessage);
                        }

                        else {

                            setToastMessage(errorMessage);

                        }
                    }
                });
    }

    private void checkIfPasswordEmailTypedIn(String email, String password){
        if (TextUtils.isEmpty(email)) {
            setToastMessage("Please enter email!!");
        }

        if (TextUtils.isEmpty(password)) {
            setToastMessage("Please enter password!!");
        }
    }

}