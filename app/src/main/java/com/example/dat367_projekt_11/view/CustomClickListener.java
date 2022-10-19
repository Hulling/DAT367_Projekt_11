package com.example.dat367_projekt_11.view;

import com.example.dat367_projekt_11.models.Profile;

/**
 * This is a interface which allows the adapter to listen to OnClick in profileCard,
 * and access the clicked profile.
 *
 * @author  Kristin Hulling
 * @version 1.0
 * @since   2022-10-16
 */

public interface CustomClickListener {
    void cardClicked(Profile profile);
}
