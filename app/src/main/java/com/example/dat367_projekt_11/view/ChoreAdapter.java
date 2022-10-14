package com.example.dat367_projekt_11.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.ChoreCardBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Profile;


import java.util.List;

public class ChoreAdapter extends RecyclerView.Adapter<ChoreAdapter.ChoreViewHolder> implements CheckboxClickListener{
    private List<Chore>choreModelList; //lista för kort
    private Context context;
    private ChoreAdapterDataModel choreAdapterDataModel;
    private List<Chore> completedChoreModellist;
    private CheckBox checkBox;


    public ChoreAdapter(List<Chore> choreModelList, Context context) {
        this.choreModelList = choreModelList;
        this.context = context;
    }

    @Override
    public void CheckBoxClicked(Chore chore) {
          if(chore.isComplete()){
            chore.unCompleteChore();
            Toast.makeText(context,"available",Toast.LENGTH_SHORT).show();
        } else{
            chore.completeChore();
            Toast.makeText(context,"done",Toast.LENGTH_SHORT).show();
        }


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
        Chore choreModel = choreModelList.get(position);
        holder.choreCardBinding.setModel(choreModel);
        holder.choreCardBinding.setCheckBoxClickListener(this);
    }



    @Override
    public int getItemCount() {
        return choreModelList.size();
    }




}

