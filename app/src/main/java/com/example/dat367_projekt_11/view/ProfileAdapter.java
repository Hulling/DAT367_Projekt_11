package com.example.dat367_projekt_11.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.ProfileCardBinding;
import com.example.dat367_projekt_11.models.CustomClickListener;
import com.example.dat367_projekt_11.models.Profile;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> implements CustomClickListener {

    private List<Profile> profileModelList;
    private Context context;

    //private MutableLiveData<Profile> clickedProfile = new MutableLiveData<>();

    public ProfileAdapter(List<Profile> profileModelList, Context context) {
        this.profileModelList = profileModelList;
        this.context = context;
    }
    /*public MutableLiveData<Profile> getClickedProfile(){
        if(clickedProfile == null){
            clickedProfile = new MutableLiveData<>();
        }
        return clickedProfile;
    }*/

    public static class ProfileViewHolder extends RecyclerView.ViewHolder {
        public ProfileCardBinding profileCardBinding;

        public ProfileViewHolder(ProfileCardBinding profileCardBinding) {
            super(profileCardBinding.getRoot());
            this.profileCardBinding = profileCardBinding;
        }
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProfileCardBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.profile_card, parent, false);

        return new ProfileViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        Profile profileModel = profileModelList.get(position);
        holder.profileCardBinding.setModel(profileModel);
        holder.profileCardBinding.setItemClickListener(this);
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return profileModelList.size();
    }

   @Override
    public void cardClicked(Profile profile) {
        //clickedProfile.setValue(profile);
        Toast.makeText(context, "Du klickade på " + profile.getName(),
                Toast.LENGTH_LONG).show();
       Intent i = new Intent(context.getApplicationContext(),MainActivity.class);
       i.putExtra("PROFILE",profile);
       context.startActivity(i);
       //Intent intent = new Intent(context.getApplicationContext(), MainActivity.class);
       //context.startActivity(intent);

    }
}
