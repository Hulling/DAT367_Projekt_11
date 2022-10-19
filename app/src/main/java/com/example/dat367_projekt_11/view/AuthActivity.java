package com.example.dat367_projekt_11.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.dat367_projekt_11.R;

/**
 * AuthActivity is displaying all fragments that is related with auth.
 *
 * @author  Kristin Hulling
 */

public class AuthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_login);
    }
}