package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentDonechoresBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.viewModels.DoneChoresViewModel;
import java.util.List;

public class DoneChoresView extends Fragment {
    private FragmentDonechoresBinding binding;
    private DoneChoresViewModel doneChoresViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDonechoresBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        doneChoresViewModel = new ViewModelProvider(this).get(DoneChoresViewModel.class);
        binding.setDoneChoresViewModel(doneChoresViewModel);
        populateData();
        return binding.getRoot();
    }
   /// -> hämta profilen från view -> skickar in profilen till modellen. //
   ///  doneChoresViewModel.setProfile();

    private void populateData() {
        List<Chore> choreModelList = doneChoresViewModel.getChoreModellist();
        Profile profile = (Profile) getActivity().getIntent().getSerializableExtra("PROFILE");
        ChoreAdapter choreAdapter = new ChoreAdapter(profile.getDoneChores(), getContext());
        binding.setChoreAdapter(choreAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
