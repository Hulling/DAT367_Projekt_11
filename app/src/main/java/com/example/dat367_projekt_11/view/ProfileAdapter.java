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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The class ProfileAdapter is used to handle a recycleView that can be populated with cards.
 * The Class is inspired from:
 * https://www.digitalocean.com/community/tutorials/android-recyclerview-data-binding
 *
 * @author  Kristin Hulling
 * @version 1.0
 * @since   2022-10-16
 */


public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> implements CustomClickListener {

    private final HashMap<String, Profile> profileModelList;
    private final Context context;

    public ProfileAdapter(HashMap<String, Profile> profileModelList, Context context) {
        this.profileModelList = profileModelList;
        this.context = context;
    }

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
    /**
     * OnBindViewHolder can only get position of a arraylist, not a hashmap. Hashmap must therefore
     * be converted to an arraylist. The conversion is retrieved from:
     * https://stackoverflow.com/questions/53969452/get-key-and-value-based-on-position-with-recyclerview-and-hashmap
     */
    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            List<Profile> profileArrayList = new ArrayList<>(profileModelList.values());
            Profile profileModel = profileArrayList.get(position);
            holder.profileCardBinding.setProfile(profileModel);
            holder.profileCardBinding.setItemClickListener(this);
        }
    }

    @Override
    public int getItemCount() {
        return profileModelList.size();
    }

    /**
     * The method sends with the intent the profile that has been clicked via serializable.
     * @param profile Profile that has been clicked.
     */
   @Override
    public void cardClicked(Profile profile) {
        Toast.makeText(context, "You clicked on " + profile.getName(),
                Toast.LENGTH_LONG).show();
       Intent i = new Intent(context.getApplicationContext(),MainActivity.class);
       i.putExtra("PROFILE",profile);
       context.startActivity(i);

    }
}
