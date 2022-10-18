package com.example.dat367_projekt_11.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.ChoreCardBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.FacadeCurrentHousehold;
import com.example.dat367_projekt_11.models.GetCurrentProfile;
import com.example.dat367_projekt_11.models.Household;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *This class represents the ChoreAdapter ..continue.
 * @author Hanna Harnesk
 */

public class ChoreAdapter extends RecyclerView.Adapter<ChoreAdapter.ChoreViewHolder> implements CheckboxClickListener{
    private Map<String, Chore> choreModelList;
    private Context context;
    private ChoreAdapterDataModel choreAdapterDataModel;
    private Household household;


    public ChoreAdapter(HashMap<String, Chore> choreModelList, Context context, ChoreAdapterDataModel choreAdapterDataModel, Household household) {
        this.choreModelList = choreModelList;
        this.context = context;
        this.choreAdapterDataModel = choreAdapterDataModel;
        this.household = household;
    }


    @Override
    public void CheckBoxClicked(Chore chore) {
        FacadeCurrentHousehold facadeGetHousehold = new FacadeCurrentHousehold(context);
        GetCurrentProfile getCurrentProfile = GetCurrentProfile.getInstance();
        facadeGetHousehold.addChoreToDoneChores(household, chore);
        choreAdapterDataModel.moveChore(chore, household);
        facadeGetHousehold.addPointsToProfile(household, getCurrentProfile.getProfile().getCurrentPoints());
        Toast.makeText(context,"checkbox clicked",Toast.LENGTH_SHORT).show();
    }


    public static class ChoreViewHolder extends RecyclerView.ViewHolder {
        public ChoreCardBinding choreCardBinding;

        public ChoreViewHolder(ChoreCardBinding choreCardBinding) {
            super(choreCardBinding.getRoot());
            this.choreCardBinding = choreCardBinding;


        }

    }


    //recyklerview kallar denna metod
    //metoden kallas när det behövs skapas en ny viewholder, metoden skapar och initialiserar viewholdern och dess
    //associerade view men fyller inte i dess innehåll (content) (den är inte ännu buden till specifik data)
    @NonNull
    @Override
    public ChoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ChoreCardBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.chore_card, parent, false);


        return new ChoreViewHolder(binding);
    }

    /*recyklerview kallar denna metod för att associera viewholder med data,*/

    @Override
    public void onBindViewHolder(@NonNull ChoreViewHolder holder, int position) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            List<Chore> choreArrayList = new ArrayList<>(choreModelList.values());
            Chore choreModel = choreArrayList.get(position);
            holder.choreCardBinding.setModel(choreModel);
            holder.choreCardBinding.setCheckBoxClickListener(this);
        }
    }



    @Override
    public int getItemCount() {
        return choreModelList.size();
    }




}

